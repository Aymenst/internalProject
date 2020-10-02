package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.Sector;

import java.util.List;

public interface SectorService {
    Sector saveSector(Sector sector);
    Sector updateSector(Sector sector);
    ResponseEntity<?> deleteSector(String sectorId);
    List<Sector> getAllSector();
    List<Sector> getSectorByPrimary(String name);
    List<Sector> getSectorByType(String type);
}
