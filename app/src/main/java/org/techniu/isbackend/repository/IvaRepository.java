package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Iva;

import java.util.List;

public interface IvaRepository extends MongoRepository<Iva, String> {
    Iva findAllByCountry(String country);
    Iva findAllByState(String state);
    Iva findAllBy_id(String id);
}
