package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.AbsenceTypeMapper;
import org.techniu.isbackend.dto.model.AbsenceTypeDto;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.AbsenceTypeRepository;
import org.techniu.isbackend.repository.StateCountryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.ExceptionType.DUPLICATE_ENTITY;

@Service
@Transactional
public class AbsenceTypeServiceImpl implements AbsenceTypeService {

    private AbsenceTypeRepository absenceTypeRepository;
    private StateCountryRepository stateCountryRepository;
    private final AbsenceTypeMapper absenceTypeMapper = Mappers.getMapper(AbsenceTypeMapper.class);

    AbsenceTypeServiceImpl(AbsenceTypeRepository absenceTypeRepository, StateCountryRepository stateCountryRepository) {
        this.absenceTypeRepository = absenceTypeRepository;
        this.stateCountryRepository = stateCountryRepository;
    }

    @Override
    public void save(AbsenceTypeDto absenceTypeDto) {
        StateCountry stateCountry = stateCountryRepository.findById(absenceTypeDto.getStateId()).get();
        AbsenceType absenceType = absenceTypeMapper.dtoToModel(absenceTypeDto);
        absenceType.setState(stateCountry);

        if (absenceTypeDto.getCode().contains(" ")) {
            throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }
        Optional<AbsenceType>  absenceType1= Optional.ofNullable(absenceTypeRepository.findByName(absenceTypeDto.getName()));
        if (absenceType1.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }
        Optional<AbsenceType>  absenceType2= Optional.ofNullable(absenceTypeRepository.findByCode(absenceTypeDto.getCode()));
        if (absenceType1.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }

        absenceTypeRepository.save(absenceType);
    }

    @Override
    public void update(AbsenceTypeDto absenceTypeDto) {
        System.out.println(absenceTypeDto.getAbsenceTypeId());
        AbsenceType absenceType = absenceTypeRepository.findById(absenceTypeDto.getAbsenceTypeId()).get();
        absenceType.setCode(absenceTypeDto.getCode());
        absenceType.setName(absenceTypeDto.getName());
        absenceType.setDescription(absenceTypeDto.getDescription());

        if (absenceTypeDto.getCode().contains(" ")) {
            throw exception(CODE_SHOULD_NOT_CONTAIN_SPACES);
        }

        absenceTypeRepository.save(absenceType);
    }

    @Override
    public void remove(String id) {

        Optional<AbsenceType> action = Optional.ofNullable(absenceTypeRepository.findBy_id(id));
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        absenceTypeRepository.deleteById(id);
    }

    @Override
    public List<AbsenceTypeDto> getAll() {

        List<AbsenceType> absenceTypes = absenceTypeRepository.findAll();
        // Create a list of all actions dto
        List<AbsenceTypeDto> absenceTypeDtos = new ArrayList<>();

        for (AbsenceType absenceType : absenceTypes) {
            AbsenceTypeDto absenceTypeDto=absenceTypeMapper.modelToDto(absenceType);
            absenceTypeDto.setStateId(absenceType.getState().get_id());
            absenceTypeDto.setStateName(absenceType.getState().getStateName());
            absenceTypeDto.setCountryName(absenceType.getState().getCountry().getCountryName());
            absenceTypeDtos.add(absenceTypeDto);
        }
        return absenceTypeDtos;
    }

    @Override
    public List<AbsenceTypeDto> getAllByState(String stateCountryId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateCountryId).get();

        List<AbsenceType> absenceTypes = absenceTypeRepository.getAllByState(stateCountry);
        // Create a list of all actions dto
        List<AbsenceTypeDto> absenceTypeDtos = new ArrayList<>();

        for (AbsenceType absenceType : absenceTypes) {
            AbsenceTypeDto absenceTypeDto=absenceTypeMapper.modelToDto(absenceType);
            absenceTypeDto.setStateId(absenceType.getState().get_id());
            absenceTypeDto.setStateName(absenceType.getState().getStateName());
            absenceTypeDto.setCountryName(absenceType.getState().getCountry().getCountryName());
            absenceTypeDtos.add(absenceTypeDto);
        }
        return absenceTypeDtos;
    }


    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.AbsenceType, exceptionType, args);
    }
}
