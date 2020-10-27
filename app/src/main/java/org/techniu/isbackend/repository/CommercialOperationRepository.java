package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.CommercialOperation;

public interface CommercialOperationRepository extends MongoRepository<CommercialOperation, String> {

    CommercialOperation findByName(String name);
    CommercialOperation findByCode(String code);
    CommercialOperation findBy_id(String id);
}
