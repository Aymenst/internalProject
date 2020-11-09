package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.ContractTypeMapper;
import org.techniu.isbackend.dto.model.ContractTypeDto;
import org.techniu.isbackend.entity.ContractType;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.ContractTypeRepository;
import org.techniu.isbackend.repository.StateCountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.ExceptionType.DUPLICATE_ENTITY;

@Service
@Transactional
public class ContractTypeServiceImpl implements ContractTypeService {

    private ContractTypeRepository contractTypeRepository;
    private StateCountryRepository stateCountryRepository;
    private final ContractTypeMapper contractTypeMapper = Mappers.getMapper(ContractTypeMapper.class);

    ContractTypeServiceImpl(ContractTypeRepository contractTypeRepository, StateCountryRepository stateCountryRepository) {
        this.contractTypeRepository = contractTypeRepository;
        this.stateCountryRepository = stateCountryRepository;
    }

    @Override
    public void save(ContractTypeDto contractTypeDto) {
        StateCountry stateCountry = stateCountryRepository.findById(contractTypeDto.getStateId()).get();
        ContractType contractType = contractTypeMapper.dtoToModel(contractTypeDto);
        contractType.setState(stateCountry);

        if (contractTypeDto.getCode().contains(" ")) {
            throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
        Optional<ContractType>  contractType1= Optional.ofNullable(contractTypeRepository.findByName(contractTypeDto.getName()));
        if (contractType1.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        Optional<ContractType>  contractType2= Optional.ofNullable(contractTypeRepository.findByCode(contractTypeDto.getCode()));
        if (contractType1.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }

        contractTypeRepository.save(contractType);
    }

    @Override
    public void update(ContractTypeDto contractTypeDto) {
        ContractType contractType = contractTypeRepository.findById(contractTypeDto.getContractTypeId()).get();
        contractType.setCode(contractTypeDto.getCode());
        contractType.setName(contractTypeDto.getName());
        contractType.setDescription(contractTypeDto.getDescription());

        if (contractTypeDto.getCode().contains(" ")) {
            throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }

        contractTypeRepository.save(contractType);
    }

    @Override
    public void remove(String id) {

        Optional<ContractType> action = Optional.ofNullable(contractTypeRepository.findBy_id(id));
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        contractTypeRepository.deleteById(id);
    }

    @Override
    public List<ContractTypeDto> getAllContractTypes() {

        List<ContractType> contractTypes = contractTypeRepository.findAll();
        // Create a list of all actions dto
        List<ContractTypeDto> contractTypeDtos = new ArrayList<>();

        for (ContractType contractType : contractTypes) {
            ContractTypeDto contractTypeDto=contractTypeMapper.modelToDto(contractType);
            contractTypeDto.setStateId(contractType.getState().get_id());
            contractTypeDto.setStateName(contractType.getState().getStateName());
            contractTypeDto.setCountryName(contractType.getState().getCountry().getCountryName());
            contractTypeDtos.add(contractTypeDto);
        }
        return contractTypeDtos;
    }

    @Override
    public List<ContractTypeDto> getAllByState(String stateCountryId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateCountryId).get();

        List<ContractType> contractTypes = contractTypeRepository.getAllByState(stateCountry);
        // Create a list of all actions dto
        List<ContractTypeDto> contractTypeDtos = new ArrayList<>();

        for (ContractType contractType : contractTypes) {
            ContractTypeDto contractTypeDto=contractTypeMapper.modelToDto(contractType);
            contractTypeDto.setStateId(contractType.getState().get_id());
            contractTypeDto.setStateName(contractType.getState().getStateName());
            contractTypeDto.setCountryName(contractType.getState().getCountry().getCountryName());
            contractTypeDtos.add(contractTypeDto);
        }
        return contractTypeDtos;
    }


    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.ContractType, exceptionType, args);
    }
}
