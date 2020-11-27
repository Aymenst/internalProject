package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.CivilityTitle;

public interface CivilityTitleRepository extends MongoRepository<CivilityTitle, String> {

    CivilityTitle findByName(String name);
    CivilityTitle findByCode(String code);
    CivilityTitle findBy_id(String id);
}
