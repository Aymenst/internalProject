package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Sector;

import java.util.List;

public interface SectorRepository  extends MongoRepository<Sector, String> {
    Sector findByName(String name);

    List<Sector> findByPrimary(Sector s);

    List<Sector> findByType(String type);
}
