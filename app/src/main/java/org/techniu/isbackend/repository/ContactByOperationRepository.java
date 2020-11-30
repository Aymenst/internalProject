package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.ContactByOperation;

public interface ContactByOperationRepository extends MongoRepository<ContactByOperation, String> {
    ContactByOperation findBy_id(String id);
    ContactByOperation findBy_idAndContactsType(String id,String contactype);
}
