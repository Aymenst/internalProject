package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Bill;

public interface BillRepository extends MongoRepository<Bill, String> {

    Bill findAllBy_id(String id);
}
