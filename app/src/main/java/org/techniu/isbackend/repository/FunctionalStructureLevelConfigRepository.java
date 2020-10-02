package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.FunctionalStructureLevelConfig;
import org.techniu.isbackend.entity.SectorConfig;

import java.util.List;

public interface FunctionalStructureLevelConfigRepository extends MongoRepository<FunctionalStructureLevelConfig, String> {

    List<FunctionalStructureLevelConfig> findByLevel1(String level1);

    List<FunctionalStructureLevelConfig> findByLevel2(String level2);

    List<FunctionalStructureLevelConfig> findByLevel3(String level3);

}
