package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.StaffDocuments;

public interface StaffDocumentsRepository extends MongoRepository<StaffDocuments, String> {
}
