package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface FunctionalStructureLevelService {
    Boolean saveLevel(List<Object> objects);
    FunctionalStructureLevel updateLevel(List<Object> objects, String levelId);
    FunctionalStructureLevel getLevelByName(String name);
    ResponseEntity<?> deleteLevel(String levelId);
    List<FunctionalStructureLevel> getAllLevels();
    List<FunctionalStructureLevel> getLevelByType(String type);
    List<Staff> setLevelStaffs(List<Object> staffs);
    List<FunctionalStructureLevel> getFunctionalStructureTree(String levelId);

}
