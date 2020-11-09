package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.AbsenceTypeAddrequest;
import org.techniu.isbackend.dto.mapper.AbsenceTypeMapper;
import org.techniu.isbackend.dto.mapper.AbsenceTypeMapper;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.AbsenceTypeService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.AbsenceType;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.ExceptionType.DELETED;
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

    @RequestMapping(path = "absenceType-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbsenceType> getAllAbsenceTypes(){
        return absenceTypeService.getAllAbsenceTypes();
    }

    @RequestMapping(path = "absenceType-all-by-state/{stateCountryId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AbsenceType> getAllByState(@PathVariable("stateCountryId") String stateCountryId){
        return absenceTypeService.getAllByState(stateCountryId);
    }

    @RequestMapping(path = "absenceType-update/{absenceTypeId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public AbsenceType updateAbsenceType(@PathVariable("absenceTypeId") String absenceTypeId, @RequestBody AbsenceType absenceType){
        return absenceTypeService.updateAbsenceType(absenceTypeId, absenceType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") String id) {
        absenceTypeService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AbsenceType, DELETED)), HttpStatus.OK);
    }

    
}
