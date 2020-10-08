package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.CommercialOperationStatus;

import java.util.List;

public interface CommercialOperationStatusRepository extends MongoRepository<CommercialOperationStatus, String> {

    List<CommercialOperationStatus> findByName(String name);
    CommercialOperationStatus findBy_id(String id);
}
