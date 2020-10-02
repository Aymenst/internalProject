package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.FunctionalStructureLevelConfig;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.FunctionalStructureLevelConfigRepository;
import org.techniu.isbackend.repository.FunctionalStructureLevelRepository;
import org.techniu.isbackend.repository.SectorConfigRepository;

import java.util.List;

@Service
@Transactional
public class FunctionalStructureLevelConfigServiceImpl implements FunctionalStructureLevelConfigService {
    FunctionalStructureLevelConfigRepository levelConfigRepository;
    FunctionalStructureLevelRepository levelRepository;
    FunctionalStructureLevelConfigServiceImpl(FunctionalStructureLevelConfigRepository levelConfigRepository, FunctionalStructureLevelRepository levelRepository ) {
        this.levelConfigRepository = levelConfigRepository;
        this.levelRepository = levelRepository;
    }

    @Override
    public FunctionalStructureLevelConfig saveLevelConfig(FunctionalStructureLevelConfig levelConfig) {
        if(levelConfig.getLevel3() != null) {

            FunctionalStructureLevel level2 = levelRepository.findByName(levelConfig.getLevel2());
            levelConfig.setLevel1(level2.getParent().getName());
        }
        return levelConfigRepository.save(levelConfig);
    }

    @Override
    public FunctionalStructureLevelConfig updateLevelConfig(FunctionalStructureLevelConfig levelConfig) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteLevelConfig(String levelConfigId) {
        return null;
    }

    @Override
    public List<FunctionalStructureLevelConfig> getAllLevelConfig() {
        return levelConfigRepository.findAll();
    }

    @Override
    public List<FunctionalStructureLevelConfig> getLevelConfigByLevel1(String level1) {
        return levelConfigRepository.findByLevel1(level1);
    }

    @Override
    public List<FunctionalStructureLevelConfig> getLevelConfigByLevel2(String level2) {
        return levelConfigRepository.findByLevel2(level2);
    }

    @Override
    public List<FunctionalStructureLevelConfig> getLevelConfigByLevel3(String level3) {
        return levelConfigRepository.findByLevel3(level3);
    }
}
