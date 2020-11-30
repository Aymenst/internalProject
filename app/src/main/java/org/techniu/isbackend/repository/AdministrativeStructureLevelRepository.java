package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.AdministrativeStructureLevel;

import java.util.List;

public interface AdministrativeStructureLevelRepository extends MongoRepository<AdministrativeStructureLevel, String> {
    AdministrativeStructureLevel findByName(String name);

    List<AdministrativeStructureLevel> findByType(String type);

    AdministrativeStructureLevel findByChildsContaining(AdministrativeStructureLevel level);
}
