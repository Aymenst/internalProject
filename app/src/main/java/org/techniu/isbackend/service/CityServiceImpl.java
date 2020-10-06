package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.repository.CityRepository;
import org.techniu.isbackend.repository.CountryRepository;
import org.techniu.isbackend.repository.StateCountryRepository;

import java.util.List;
@Service
public class CityServiceImpl implements CityService{
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    private StateCountryRepository stateCountryRepository;
    CityServiceImpl(CityRepository cityRepository, StateCountryRepository stateCountryRepository,CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.stateCountryRepository = stateCountryRepository;
    }
    @Override
    public City saveCity(Country country, StateCountry stateCountry, City city) {
        // save country if note existe
       Country country1=countryRepository.save(country);
        // save state if note existe
        StateCountry stateCountry1=stateCountryRepository.save(stateCountry.setCountry(country1));
        // save state if note existe
        return cityRepository.save(city.setStateCountry(stateCountry1));
    }

    @Override
    public City updateCity(String cityId, City city) {
        return cityRepository.findById(cityId).map(city1 -> {
            city.set_id(city1.get_id());
            return cityRepository.save(city);
        }).orElseThrow(() -> new ExceptionMessage("Cannot update this city"));
    }

    @Override
    public ResponseEntity<?> deleteCity(String cityId) {
        return null;
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> getAllCityByState(String stateId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateId).get();
        return cityRepository.findAllByStateCountry(stateCountry);
    }
}
