package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Contract;
import org.techniu.isbackend.entity.FunctionalStructureLevel;

import java.util.List;

public interface ContractRepository extends MongoRepository<Contract, String> {
}
