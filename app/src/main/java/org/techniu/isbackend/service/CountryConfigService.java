package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.CountryConfig;

import java.util.List;

public interface CountryConfigService {
    CountryConfig saveCountryConfig(CountryConfig countryConfig);
    CountryConfig updateCountryConfig(CountryConfig countryConfig);
    ResponseEntity<?> deleteCountryConfig(String countryConfigId);
    List<CountryConfig> getAllCountryConfig();
    CountryConfig getCountryConfigByCountry(String countryId);
}
