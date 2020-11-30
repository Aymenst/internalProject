package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.FunctionalStructureAssignationHistoryDto;

import java.util.List;

public interface FunctionalStructureAssignationHistoryService {
    void deleteFunctionalStructureAssignationHistory(String functionalStructureAssignationHistoryId);
    List<FunctionalStructureAssignationHistoryDto> getAllFunctionalStructureAssignationHistory();
    List<FunctionalStructureAssignationHistoryDto> getFunctionalStructureAssignationHistoryByLevel(String levelId);
    List<FunctionalStructureAssignationHistoryDto> getFunctionalStructureAssignationHistoryByStaff(String staffId);
}
