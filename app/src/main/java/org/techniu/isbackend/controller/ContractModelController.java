package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.ContractModelAddrequest;
import org.techniu.isbackend.controller.request.ContractModelUpdaterequest;
import org.techniu.isbackend.dto.mapper.ContractModelMapper;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ContractModelService;

import javax.validation.Valid;

import static org.techniu.isbackend.exception.EntityType.ContractModel;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/contractModel")
@CrossOrigin("*")
public class ContractModelController {
    private ContractModelService contractModelService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ContractModelMapper contractModelMapper = Mappers.getMapper(ContractModelMapper.class);

    ContractModelController(ContractModelService contractModelService, MapValidationErrorService mapValidationErrorService){
        this.contractModelService = contractModelService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ContractModelAddrequest contractModelAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save ContractModel
        System.out.println(contractModelMapper.addRequestToDto(contractModelAddrequest));
        contractModelService.save(contractModelMapper.addRequestToDto(contractModelAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractModel, ADDED)), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity getAllContractModels(){
        return new ResponseEntity<Response>(Response.ok().setPayload(contractModelService.getAll()), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody ContractModelUpdaterequest contractModelUpdaterequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        contractModelService.update(contractModelMapper.updateRequestToDto(contractModelUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractModel, UPDATED)), HttpStatus.OK);

    }

    @DeleteMapping("/delete/oldId={oldId}&newId={newId}")
    public ResponseEntity delete(@PathVariable("oldId") String oldId, @PathVariable("newId") String newId) {
        contractModelService.remove(oldId, newId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ContractModel, DELETED)), HttpStatus.OK);
    }


}
