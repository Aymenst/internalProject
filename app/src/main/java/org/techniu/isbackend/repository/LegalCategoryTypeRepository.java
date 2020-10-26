package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.LegalCategoryType;

import java.util.List;

public interface LegalCategoryTypeRepository extends MongoRepository<LegalCategoryType, String> {

    List<LegalCategoryType> getAllByCompanyName(String companyName);
}
