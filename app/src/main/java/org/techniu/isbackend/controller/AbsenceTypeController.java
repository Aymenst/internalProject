package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.service.AbsenceTypeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AbsenceTypeController {
    private AbsenceTypeService absenceTypeService;
    AbsenceTypeController(AbsenceTypeService absenceTypeService){
        this.absenceTypeService = absenceTypeService;
    }
    @RequestMapping(path = "absenceType-save/{stateCountryId}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public AbsenceType saveAbsenceType(@RequestBody AbsenceType absenceType, @PathVariable("stateCountryId") String stateCountryId){
        return absenceTypeService.saveAbsenceType(absenceType, stateCountryId) ;
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

    @RequestMapping(path = "absenceType-delete/{absenceTypeId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAbsenceType(@PathVariable("absenceTypeId") String absenceTypeId){
        absenceTypeService.deleteAbsenceType(absenceTypeId);
    }

    
}
