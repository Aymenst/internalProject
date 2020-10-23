package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Iva;

public interface IvaRepository extends MongoRepository<Iva, String> {

    Iva findAllBy_id(String id);
}
