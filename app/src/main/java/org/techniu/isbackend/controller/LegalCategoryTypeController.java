package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.LegalCategoryTypeAddrequest;
import org.techniu.isbackend.controller.request.LegalCategoryTypeAddrequest;
import org.techniu.isbackend.controller.request.LegalCategoryTypeUpdaterequest;
import org.techniu.isbackend.dto.mapper.LegalCategoryTypeMapper;
import org.techniu.isbackend.dto.mapper.LegalCategoryTypeMapper;
import org.techniu.isbackend.dto.model.LegalCategoryTypeDto;
import org.techniu.isbackend.entity.LegalCategoryType;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.LegalCategoryTypeService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.*;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/legalCategoryType")
@CrossOrigin("*")
public class LegalCategoryTypeController {
    private LegalCategoryTypeService legalCategoryTypeService;
    private final MapValidationErrorService mapValidationErrorService;
    private final LegalCategoryTypeMapper legalCategoryTypeMapper = Mappers.getMapper(LegalCategoryTypeMapper.class);

    LegalCategoryTypeController(LegalCategoryTypeService legalCategoryTypeService, MapValidationErrorService mapValidationErrorService){
        this.legalCategoryTypeService = legalCategoryTypeService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid LegalCategoryTypeAddrequest legalCategoryTypeAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save LegalCategoryType
        System.out.println(legalCategoryTypeMapper.addRequestToDto(legalCategoryTypeAddrequest));
        legalCategoryTypeService.save(legalCategoryTypeMapper.addRequestToDto(legalCategoryTypeAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(LegalCategoryType, ADDED)), HttpStatus.OK);
    }


    @GetMapping("/all")
    public List<LegalCategoryTypeDto> getAllLegalCategoryTypes(){
        return legalCategoryTypeService.getAllLegalCategoryTypes();
    }

    @GetMapping("/all-by-company/{companyId}")
    public List<LegalCategoryTypeDto> getAllByCompany(@PathVariable("companyId") String companyId){
        return legalCategoryTypeService.getAllByCompany(companyId);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody LegalCategoryTypeUpdaterequest legalCategoryTypeUpdaterequest){
        legalCategoryTypeService.update(legalCategoryTypeMapper.updateRequestToDto(legalCategoryTypeUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(LegalCategoryType, UPDATED)), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        legalCategoryTypeService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(LegalCategoryType, DELETED)), HttpStatus.OK);
    }


}
