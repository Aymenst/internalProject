package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.FunctionalStructureLevel;

import java.util.List;

public interface FunctionalStructureLevelRepository extends MongoRepository<FunctionalStructureLevel, String> {
    FunctionalStructureLevel findByName(String name);

    FunctionalStructureLevel findBy_id(String id);

    List<FunctionalStructureLevel> findByType(String type);

    FunctionalStructureLevel findByChildsContaining(FunctionalStructureLevel level);
}
