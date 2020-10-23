package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.AbsenceType;

import java.util.List;

public interface AbsenceTypeService {
    AbsenceType saveAbsenceType(AbsenceType absenceType, String stateContractId);
    AbsenceType updateAbsenceType(String absenceTypeId, AbsenceType absenceType);
    void deleteAbsenceType(String absenceTypeId);
    List<AbsenceType> getAllAbsenceTypes();
    List<AbsenceType> getAllByState(String stateCountryId);
}
