package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Log;

public interface LogRepository extends MongoRepository<Log, String> {
}
