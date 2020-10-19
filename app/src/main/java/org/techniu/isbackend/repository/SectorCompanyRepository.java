package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.SectorCompany;

import java.util.List;

public interface SectorCompanyRepository extends MongoRepository<SectorCompany, String> {
    SectorCompany findByName(String name);
    List<SectorCompany> findByParent(SectorCompany sectorCompany);
}
