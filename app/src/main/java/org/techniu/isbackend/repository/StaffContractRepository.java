package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.StaffContract;

public interface StaffContractRepository extends MongoRepository<StaffContract, String> {
}
