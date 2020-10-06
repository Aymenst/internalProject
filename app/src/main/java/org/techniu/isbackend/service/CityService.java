package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface CityService {
    City saveCity(Country country, StateCountry stateCountry, City city);
    City updateCity(String cityId, City city);
    ResponseEntity<?> deleteCity(String cityId);
    List<City> getAllCity();
    List<City> getAllCityByState(String stateId);
}
