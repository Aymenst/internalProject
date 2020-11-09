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
    public List<ContractTypeDto> getAllContractTypes(){
        return contractTypeService.getAllContractTypes();
    }

    @GetMapping("/all-by-state/{stateCountryId}")
    public List<ContractTypeDto> getAllByState(@PathVariable("stateCountryId") String stateCountryId){
        return contractTypeService.getAllByState(stateCountryId);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ContractTypeUpdaterequest contractTypeUpdaterequest){
        contractTypeService.update(contractTypeMapper.updateRequestToDto(contractTypeUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractType, UPDATED)), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        contractTypeService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractType, DELETED)), HttpStatus.OK);
    }


}
