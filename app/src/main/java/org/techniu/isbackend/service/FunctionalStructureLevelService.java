package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.dto.model.FunctionalStructureLevelDto;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface FunctionalStructureLevelService {
    Boolean save(List<Object> objects);
    FunctionalStructureLevel update(FunctionalStructureLevelDto functionalStructureLevelDto, String oldLeaderId, String newLeaderId);
    FunctionalStructureLevel getLevelByName(String name);
    ResponseEntity<?> remove(String levelId);
    List<FunctionalStructureLevelDto> getAll();
    List<FunctionalStructureLevelDto> getAllByType(String type);
    List<Staff> setLevelStaffs(List<Object> staffs);
    List<FunctionalStructureLevel> getFunctionalStructureTree(String levelId);

}
