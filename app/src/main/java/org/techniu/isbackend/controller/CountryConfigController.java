package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.controller.request.CountryConfigAddrequest;
import org.techniu.isbackend.dto.mapper.CommercialOperationStatusMapper;
import org.techniu.isbackend.dto.mapper.CountryConfigMapper;
import org.techniu.isbackend.entity.CountryConfig;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.CountryConfigService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.CommercialOperationStatus;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/countryConfig")
@CrossOrigin("*")
public class CountryConfigController {
    private CountryConfigService countryConfigService;
    private final MapValidationErrorService mapValidationErrorService;
    private final CountryConfigMapper countryConfigMapper = Mappers.getMapper(CountryConfigMapper.class);
    CountryConfigController(CountryConfigService countryConfigService, MapValidationErrorService mapValidationErrorService){
        this.countryConfigService = countryConfigService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CountryConfigAddrequest countryConfigAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save CountryConfig
        System.out.println(countryConfigMapper.addRequestToDto(countryConfigAddrequest));
        countryConfigService.saveCountryConfig(countryConfigMapper.addRequestToDto(countryConfigAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CommercialOperationStatus, ADDED)), HttpStatus.OK);
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
