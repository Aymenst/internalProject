package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.dto.model.CountryConfigDto;
import org.techniu.isbackend.entity.CountryConfig;

import java.util.List;

public interface CountryConfigService {
    void saveCountryConfig(CountryConfigDto countryConfigDto);
    CountryConfig updateCountryConfig(CountryConfig countryConfig);
    ResponseEntity<?> deleteCountryConfig(String countryConfigId);
    List<CountryConfig> getAllCountryConfig();
    CountryConfig getCountryConfigByCountry(String countryId);
}
