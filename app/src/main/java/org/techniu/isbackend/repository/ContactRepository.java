package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Contact;

public interface ContactRepository extends MongoRepository<Contact, String> {

    Contact findByFirstName(String firstName);
    Contact findByPersonalEmail(String personalEmail);
    Contact findBy_id(String id);
}
