package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.StaffDocument;

public interface StaffDocumentRepository extends MongoRepository<StaffDocument, String> {

    StaffDocument findByNumber(String number);
}
