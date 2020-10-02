package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.SectorConfig;

import java.util.List;

public interface SectorConfigService {
    SectorConfig saveSectorConfig(SectorConfig sectorConfig);
    SectorConfig updateSectorConfig(SectorConfig sectorConfig);
    ResponseEntity<?> deleteSectorConfig(String sectorConfigId);
    List<SectorConfig> getAllSectorConfig();
    List<SectorConfig> getSectorConfigByPrimarySector(String primary);
}
