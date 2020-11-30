package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.dto.model.AdministrativeStructureLevelDto;
import org.techniu.isbackend.entity.AdministrativeStructureLevel;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface AdministrativeStructureLevelService {
    Boolean save(List<Object> objects);
    AdministrativeStructureLevel update(AdministrativeStructureLevelDto administrativeStructureLevelDto, String oldLeaderId, String newLeaderId);
    AdministrativeStructureLevel getLevelByName(String name);
    ResponseEntity<?> remove(String levelId);
    List<AdministrativeStructureLevelDto> getAll();
    List<AdministrativeStructureLevelDto> getAllByType(String type);
    List<Staff> setLevelStaffs(List<Object> staffs);
    List<AdministrativeStructureLevel> getAdministrativeStructureTree(String levelId);

}
