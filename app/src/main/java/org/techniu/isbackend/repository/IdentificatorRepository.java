package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Identificator;

import java.util.List;

public interface IdentificatorRepository extends MongoRepository<Identificator, String> {
}
