package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.SectorConfig;
import org.techniu.isbackend.repository.SectorConfigRepository;

import java.util.List;
@Service
@Transactional
public class SectorConfigServiceImpl implements SectorConfigService {
    private SectorConfigRepository sectorConfigRepository;
    SectorConfigServiceImpl(SectorConfigRepository sectorConfigRepository) {
        this.sectorConfigRepository = sectorConfigRepository;

    }
    @Override
    public SectorConfig saveSectorConfig(SectorConfig sectorConfig) {
        return sectorConfigRepository.save(sectorConfig);
    }

    @Override
    public SectorConfig updateSectorConfig(SectorConfig sectorConfig) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteSectorConfig(String sectorConfigId) {
        return null;
    }

    @Override
    public List<SectorConfig> getAllSectorConfig() {
        return sectorConfigRepository.findAll();
    }

    @Override
    public List<SectorConfig> getSectorConfigByPrimarySector(String primary) {
        return sectorConfigRepository.findByPrimarySector(primary);
    }
}
