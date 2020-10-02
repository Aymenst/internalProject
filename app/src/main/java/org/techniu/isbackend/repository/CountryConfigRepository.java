package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.entity.CountryConfig;

public interface CountryConfigRepository  extends MongoRepository<CountryConfig, String> {
    CountryConfig getByCountry(Country country);
}
