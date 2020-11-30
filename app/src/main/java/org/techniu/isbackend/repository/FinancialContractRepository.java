package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.FinancialContract;

public interface FinancialContractRepository extends MongoRepository<FinancialContract, String> {

    FinancialContract findAllBy_id(String id);

}
