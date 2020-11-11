package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.AbsenceTypeAddrequest;
import org.techniu.isbackend.controller.request.AbsenceTypeAddrequest;
import org.techniu.isbackend.controller.request.AbsenceTypeUpdaterequest;
import org.techniu.isbackend.dto.mapper.AbsenceTypeMapper;
import org.techniu.isbackend.dto.mapper.AbsenceTypeMapper;
import org.techniu.isbackend.dto.model.AbsenceTypeDto;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.AbsenceTypeService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.*;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/absenceType")
@CrossOrigin("*")
public class AbsenceTypeController {
    private AbsenceTypeService absenceTypeService;
    private final MapValidationErrorService mapValidationErrorService;
    private final AbsenceTypeMapper absenceTypeMapper = Mappers.getMapper(AbsenceTypeMapper.class);

    AbsenceTypeController(AbsenceTypeService absenceTypeService, MapValidationErrorService mapValidationErrorService){
        this.absenceTypeService = absenceTypeService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid AbsenceTypeAddrequest absenceTypeAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save AbsenceType
        System.out.println(absenceTypeMapper.addRequestToDto(absenceTypeAddrequest));
        absenceTypeService.save(absenceTypeMapper.addRequestToDto(absenceTypeAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AbsenceType, ADDED)), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity getAllAbsenceTypes(){
        return new ResponseEntity<Response>(Response.ok().setPayload(absenceTypeService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/all-by-state/{stateCountryId}")
    public ResponseEntity getAllByState(@PathVariable("stateCountryId") String stateCountryId){
        return new ResponseEntity<Response>(Response.ok().setPayload(absenceTypeService.getAllByState(stateCountryId)), HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid AbsenceTypeUpdaterequest absenceTypeUpdaterequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        absenceTypeService.update(absenceTypeMapper.updateRequestToDto(absenceTypeUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AbsenceType, UPDATED)), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        absenceTypeService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AbsenceType, DELETED)), HttpStatus.OK);
    }


}
