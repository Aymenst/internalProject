package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.FunctionalStructureLevelConfig;

import java.util.List;

public interface FunctionalStructureLevelConfigService {
    FunctionalStructureLevelConfig saveLevelConfig(FunctionalStructureLevelConfig levelConfig);
    FunctionalStructureLevelConfig updateLevelConfig(FunctionalStructureLevelConfig levelConfig);
    ResponseEntity<?> deleteLevelConfig(String levelConfigId);
    List<FunctionalStructureLevelConfig> getAllLevelConfig();
    List<FunctionalStructureLevelConfig> getLevelConfigByLevel1(String level1);
    List<FunctionalStructureLevelConfig> getLevelConfigByLevel2(String level2);
    List<FunctionalStructureLevelConfig> getLevelConfigByLevel3(String level3);
}
