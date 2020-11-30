package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.ContractModel;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface ContractModelRepository extends MongoRepository<ContractModel, String> {

    ContractModel findByName(String name);
    ContractModel findByCode(String code);
}
