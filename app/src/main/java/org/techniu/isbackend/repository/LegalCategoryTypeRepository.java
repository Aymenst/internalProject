package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.LegalCategoryType;
import org.techniu.isbackend.entity.FinancialCompany;
import org.techniu.isbackend.entity.LegalCategoryType;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface LegalCategoryTypeRepository extends MongoRepository<LegalCategoryType, String> {

    List<LegalCategoryType> getAllByCompany(FinancialCompany financialCompany);
    LegalCategoryType findBy_id(String id);
    LegalCategoryType findByName(String name);
}
