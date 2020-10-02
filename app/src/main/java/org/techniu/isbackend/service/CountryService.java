package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.Country;

import java.util.List;

public interface CountryService {
    Country saveCountry(Country country);
    Country updateCountry(String countryId, Country country);
    Boolean getCountryByName(String countryName);
    ResponseEntity<?> deleteCountry(String countryId);
    List<Country> getAllCountry();
}
