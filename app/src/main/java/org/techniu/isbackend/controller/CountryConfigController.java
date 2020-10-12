package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.CountryConfig;
import org.techniu.isbackend.service.CountryConfigService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CountryConfigController {
    private CountryConfigService countryConfigService;
    CountryConfigController(CountryConfigService countryConfigService){
        this.countryConfigService = countryConfigService;
    }

    @RequestMapping(path = "country",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryConfig saveCountryConfig(@RequestBody CountryConfig countryConfig){
        return countryConfigService.saveCountryConfig(countryConfig) ;
    }

    @RequestMapping(path = "country-config/{countryId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public CountryConfig getCountryConfigByName(@PathVariable(value = "countryId") String countryId){
        return countryConfigService.getCountryConfigByCountry(countryId);
    }

    @RequestMapping(path = "countries",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryConfig> getCountryConfig(){
        return countryConfigService.getAllCountryConfig();
    }
}
