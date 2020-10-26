package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.ContractType;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface ContractTypeRepository extends MongoRepository<ContractType, String> {

    List<ContractType> getAllByState(StateCountry stateCountry);
}
