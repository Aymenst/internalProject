package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.ContractTypeAddrequest;
import org.techniu.isbackend.controller.request.ContractTypeAddrequest;
import org.techniu.isbackend.dto.mapper.ContractTypeMapper;
import org.techniu.isbackend.dto.mapper.ContractTypeMapper;
import org.techniu.isbackend.dto.model.ContractTypeDto;
import org.techniu.isbackend.entity.ContractType;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ContractTypeService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.ContractType;
import static org.techniu.isbackend.exception.EntityType.ContractType;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ContractTypeController {
    private ContractTypeService contractTypeService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ContractTypeMapper contractTypeMapper = Mappers.getMapper(ContractTypeMapper.class);

    ContractTypeController(ContractTypeService contractTypeService, MapValidationErrorService mapValidationErrorService){
        this.contractTypeService = contractTypeService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ContractTypeAddrequest contractTypeAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save ContractType
        System.out.println(contractTypeMapper.addRequestToDto(contractTypeAddrequest));
        contractTypeService.save(contractTypeMapper.addRequestToDto(contractTypeAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractType, ADDED)), HttpStatus.OK);
    }


    @RequestMapping(path = "contractType-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContractTypeDto> getAllContractTypes(){
        return contractTypeService.getAllContractTypes();
    }

    @RequestMapping(path = "contractType-all-by-state/{stateCountryId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContractTypeDto> getAllByState(@PathVariable("stateCountryId") String stateCountryId){
        return contractTypeService.getAllByState(stateCountryId);
    }

    @RequestMapping(path = "contractType-update/{contractTypeId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractType updateContractType(@PathVariable("contractTypeId") String contractTypeId, @RequestBody ContractType contractType){
        return contractTypeService.updateContractType(contractTypeId, contractType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {
        contractTypeService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractType, DELETED)), HttpStatus.OK);
    }


}
