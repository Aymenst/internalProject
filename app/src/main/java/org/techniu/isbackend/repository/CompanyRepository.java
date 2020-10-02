package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Company;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
