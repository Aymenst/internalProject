package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.dto.model.SectorCompanyDto;
import org.techniu.isbackend.entity.SectorCompany;

import java.util.List;

public interface SectorCompanyService {
    SectorCompany save(SectorCompany sectorCompany);
    SectorCompany update(SectorCompany sectorCompany);
    ResponseEntity<?> delete(String sectorId);
    List<SectorCompanyDto> getAll();
    /*List<SectorCompany> getSectorByPrimary(String name);
    List<SectorCompany> getSectorByType(String type);*/
}
