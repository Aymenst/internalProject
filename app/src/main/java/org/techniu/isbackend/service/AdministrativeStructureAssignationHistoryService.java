package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.AdministrativeStructureAssignationHistoryDto;

import java.util.List;

public interface AdministrativeStructureAssignationHistoryService {
    void deleteAdministrativeStructureAssignationHistory(String administrativeStructureAssignationHistoryId);
    List<AdministrativeStructureAssignationHistoryDto> getAllAdministrativeStructureAssignationHistory();
    List<AdministrativeStructureAssignationHistoryDto> getAdministrativeStructureAssignationHistoryByLevel(String levelId);
    List<AdministrativeStructureAssignationHistoryDto> getAdministrativeStructureAssignationHistoryByStaff(String staffId);
}
