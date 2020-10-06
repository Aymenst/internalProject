package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface StateCountryRepository extends MongoRepository<StateCountry, String> {

    StateCountry getByStateName(String countryName);

    List<StateCountry> findAllByCountry(Country country);
}