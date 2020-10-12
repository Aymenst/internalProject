package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.service.AddressService;
import org.techniu.isbackend.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/county")
@CrossOrigin("*")
public class CountryController {
    private CountryService countryService;
    CountryController(CountryService countryService){
        this.countryService = countryService;

    }
    @RequestMapping(path = "country-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Country saveCountry(@RequestBody Country country){
        return countryService.saveCountry(country);
    }

   /* @RequestMapping(path = "countries-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Country> getCountries(){
        return countryService.getAllCountry();
    }*/
   @RequestMapping(method = RequestMethod.GET, value = "/all")
   public ResponseEntity allCommercialOperationStatus() {
       return new ResponseEntity<Response>(Response.ok().setPayload(countryService.getAllCountry()), HttpStatus.OK);
   }

    @RequestMapping(path = "country-by-name/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean getCountryByName(@PathVariable(value = "name") String name){
        System.out.println(name);
        return countryService.getCountryByName(name);
    }


}
