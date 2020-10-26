package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.repository.AbsenceTypeRepository;
import org.techniu.isbackend.repository.StateCountryRepository;

import java.util.List;

@Service
@Transactional
public class AbsenceTypeServiceImpl implements AbsenceTypeService {

    private AbsenceTypeRepository absenceTypeRepository;
    private StateCountryRepository stateCountryRepository;

    AbsenceTypeServiceImpl(AbsenceTypeRepository absenceTypeRepository, StateCountryRepository stateCountryRepository) {
        this.absenceTypeRepository = absenceTypeRepository;
        this.stateCountryRepository = stateCountryRepository;
    }

    @Override
    public AbsenceType saveAbsenceType(AbsenceType absenceType, String stateContractId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateContractId).get();
        absenceType.setState(stateCountry);
        return absenceTypeRepository.save(absenceType);
    }

    @Override
    public AbsenceType updateAbsenceType(String absenceTypeId, AbsenceType absenceType) {
        AbsenceType absenceType1 = absenceTypeRepository.findById(absenceTypeId).get();
        absenceType.setAbsenceTypeId(absenceType1.getAbsenceTypeId());
        return absenceTypeRepository.save(absenceType);
    }

    @Override
    public void deleteAbsenceType(String absenceTypeId) {
        AbsenceType absenceType = absenceTypeRepository.findById(absenceTypeId).get();
        absenceTypeRepository.delete(absenceType);
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
}
