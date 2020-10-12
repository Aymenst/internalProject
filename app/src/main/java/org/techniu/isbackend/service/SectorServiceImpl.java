package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Sector;
import org.techniu.isbackend.repository.SectorRepository;

import java.util.List;
@Service
@Transactional
public class SectorServiceImpl implements SectorService {
    private SectorRepository sectorRepository;
    SectorServiceImpl(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }
    @Override
    public Sector saveSector(Sector sector) {
        return this.sectorRepository.save(sector);
    }

    @Override
    public Sector updateSector(Sector sector) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteSector(String sectorId) {
        return null;
    }

    @Override
    public List<Sector> getAllSector() {
        return sectorRepository.findAll();
    }

    @Override
    public List<Sector> getSectorByPrimary(String name) {
        Sector s = sectorRepository.findByName(name);
        if (s != null) {
            return sectorRepository.findByParent(s);
        } else {
            throw new ExceptionMessage("Cannot get Sector");
        }
    }

    @Override
    public List<Sector> getSectorByType(String type) {
        return sectorRepository.findByType(type);
    }
}
