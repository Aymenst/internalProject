package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.CityAddrequest;
import org.techniu.isbackend.dto.model.CityDto;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.CityService;

import javax.validation.Valid;

import java.util.List;

import static org.techniu.isbackend.exception.EntityType.City;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/city")
@CrossOrigin("*")
public class CityController {
    private final CityService cityService;
    private final MapValidationErrorService mapValidationErrorService;

    public CityController(CityService cityService, MapValidationErrorService mapValidationErrorService) {
        this.cityService = cityService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    /**
     * display all city GET API "/api/city"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allServices() {
        return new ResponseEntity<Response>(Response.ok().setPayload(cityService.getAllCity()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CityAddrequest cityAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        System.out.println(cityAddrequest);
        //country
        Country country = new Country();
        country.setCountryName(cityAddrequest.getCountryName());
        country.setCountryCode(cityAddrequest.getCountryCode());
        country.setPhonePrefix(cityAddrequest.getPhonePrefix());
        //StateCountry
        StateCountry stateCountry=new StateCountry();
        stateCountry.setStateName(cityAddrequest.getStateName());
        // Save City
        City city=new City();
        city.setCityName(cityAddrequest.getCityName());
        cityService.saveCity(country,stateCountry,city);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(City, ADDED)), HttpStatus.OK);
    }
    @RequestMapping(path = "all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CityDto> getStaff(){
        return cityService.getAllCity();
    }


}