package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.repository.CountryConfigRepository;
import org.techniu.isbackend.repository.CountryRepository;

import java.util.Date;
import java.util.List;
@Service
@Transactional
public class CountryConfigServiceImpl implements CountryConfigService {
    private CountryConfigRepository countryConfigRepository;
    private CountryRepository countryRepository;
    private LogService logService;
    CountryConfigServiceImpl(
            CountryConfigRepository countryConfigRepository,
            CountryRepository countryRepository, LogService logService){
        this.countryConfigRepository = countryConfigRepository;
        this.countryRepository = countryRepository;
        this.logService = logService;
    }
    @Override
    public CountryConfig saveCountryConfig(CountryConfig countryConfig) {
        Country country1 = countryRepository.getByCountryName(countryConfig.getCountry().getCountryName());
        countryConfig.setCountry(country1);
        Log log = new Log();
        log.setUserName("John Doe");
        log.setActionDate(new Date());
        log.setClassType(ClassType.COUNTRYCONFIG);
        log.setLogType(LogType.CREATE);
        return countryConfigRepository.save(countryConfig);
    }

    @Override
    public CountryConfig updateCountryConfig(CountryConfig countryConfig) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCountryConfig(String countryConfigId) {
        return null;
    }

    @Override
    public List<CountryConfig> getAllCountryConfig() {
        return countryConfigRepository.findAll();
    }

    @Override
    public CountryConfig getCountryConfigByCountry(String countryId) {
        return countryRepository.findById(countryId).map(country -> countryConfigRepository.getByCountry(country)).orElseThrow(() -> new ExceptionMessage("Cannot find country configuration"));

    }
}
