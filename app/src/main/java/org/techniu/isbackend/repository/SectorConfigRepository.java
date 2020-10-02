package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.SectorConfig;

import java.util.List;

public interface SectorConfigRepository  extends MongoRepository<SectorConfig, String> {
    List<SectorConfig> findByPrimarySector(String sector);
}
