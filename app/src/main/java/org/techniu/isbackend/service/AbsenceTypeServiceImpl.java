package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.AbsenceTypeMapper;
import org.techniu.isbackend.dto.model.AbsenceTypeDto;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.AbsenceTypeRepository;
import org.techniu.isbackend.repository.StateCountryRepository;

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
    public AbsenceType save(AbsenceTypeDto absenceTypeDto) {
        StateCountry stateCountry = stateCountryRepository.findById(absenceTypeDto.getStateId()).get();
        AbsenceType absenceType = absenceTypeMapper.dtoToModel(absenceTypeDto);
        absenceType.setState(stateCountry);

        if (absenceTypeDto.getName().contains(" ")) {
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

        return absenceTypeRepository.save(absenceType);
    }

    @Override
    public AbsenceType updateAbsenceType(String id, AbsenceType absenceType) {
        AbsenceType absenceType1 = absenceTypeRepository.findById(id).get();
        absenceType.set_id(absenceType1.get_id());
        return absenceTypeRepository.save(absenceType);
    }

    @Override
    public void remove(String id) {

        Optional<AbsenceType> action = Optional.ofNullable(absenceTypeRepository.findBy_id(id));
        // If CommercialOperationStatus doesn't exists
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        absenceTypeRepository.deleteById(id);
    }

    @Override
    public List<AbsenceType> getAllAbsenceTypes() {
        return absenceTypeRepository.findAll();
    }

    @Override
    public List<AbsenceType> getAllByState(String stateCountryId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateCountryId).get();
        return absenceTypeRepository.getAllByState(stateCountry);
    }

    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.CommercialOperationStatus, exceptionType, args);
    }
}
