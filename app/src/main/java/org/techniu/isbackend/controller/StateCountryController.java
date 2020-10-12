package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Country;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.service.CountryService;
import org.techniu.isbackend.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.techniu.isbackend.service.StateCountryService;

import java.util.List;

@RestController
@RequestMapping("/api/stateCountry")
@CrossOrigin("*")
public class StateCountryController {
    private StateCountryService stateCountryService;
    StateCountryController(StateCountryService stateCountryService){
        this.stateCountryService = stateCountryService;

    }

    @RequestMapping(method = RequestMethod.GET, value = "statesByCountry/{id}")
    public ResponseEntity getCountyState(@PathVariable String id){
        return new ResponseEntity<Response>(Response.ok().setPayload(stateCountryService.getAllState(id)), HttpStatus.OK);
    }

    }
