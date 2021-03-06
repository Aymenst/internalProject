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
import org.techniu.isbackend.controller.request.ContractTypeUpdaterequest;
import org.techniu.isbackend.dto.mapper.ContractTypeMapper;
import org.techniu.isbackend.dto.mapper.ContractTypeMapper;
import org.techniu.isbackend.dto.model.ContractTypeDto;
import org.techniu.isbackend.entity.ContractType;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ContractTypeService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.*;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/contractType")
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


    @GetMapping("/all")
    public ResponseEntity getAllContractTypes(){
        return new ResponseEntity<Response>(Response.ok().setPayload(contractTypeService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/all-by-state/{stateCountryId}")
    public ResponseEntity getAllByState(@PathVariable("stateCountryId") String stateCountryId){
        return new ResponseEntity<Response>(Response.ok().setPayload(contractTypeService.getAllByState(stateCountryId)), HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ContractTypeUpdaterequest contractTypeUpdaterequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        contractTypeService.update(contractTypeMapper.updateRequestToDto(contractTypeUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractType, UPDATED)), HttpStatus.OK);

    }

    @DeleteMapping("/delete/oldId={oldId}&newId={newId}")
    public ResponseEntity delete(@PathVariable("oldId") String oldId, @PathVariable("newId") String newId) {
        contractTypeService.remove(oldId, newId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractType, DELETED)), HttpStatus.OK);
    }


}
