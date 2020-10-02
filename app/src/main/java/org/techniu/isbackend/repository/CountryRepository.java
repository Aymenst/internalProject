package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Country;


public interface CountryRepository extends MongoRepository<Country, String> {
    Country getByCountryName(String countryName);
}
