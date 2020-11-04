package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.AbsenceTypeDto;
import org.techniu.isbackend.entity.AbsenceType;

import java.util.List;

public interface AbsenceTypeService {
    AbsenceType save(AbsenceTypeDto absenceTypeDto);
    AbsenceType updateAbsenceType(String absenceTypeId, AbsenceType absenceType);
    void remove(String id);
    List<AbsenceType> getAllAbsenceTypes();
    List<AbsenceType> getAllByState(String stateCountryId);
}
