package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.ContractStatus;

import java.util.List;

public interface ContractStatusRepository extends MongoRepository<ContractStatus, String> {
    ContractStatus findByStatusName();
    List<ContractStatus> findAllByStatusName();
    ContractStatus findAllBy_id(String id);
    ContractStatus findByStatusCode(int code);
}
