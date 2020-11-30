package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.service.FunctionalStructureAssignationHistoryService;

import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/functionalStructureAssignationHistory")
@CrossOrigin("*")
public class FunctionalStructureAssignationHistoryController {
    private FunctionalStructureAssignationHistoryService functionalStructureAssignationHistoryService;
    FunctionalStructureAssignationHistoryController(FunctionalStructureAssignationHistoryService functionalStructureAssignationHistoryService){
        this.functionalStructureAssignationHistoryService = functionalStructureAssignationHistoryService;
    }


    @GetMapping("/all")
    public ResponseEntity getAllFunctionalStructureAssignationHistory(){
        return new ResponseEntity<Response>(Response.ok().setPayload(functionalStructureAssignationHistoryService.getAllFunctionalStructureAssignationHistory()), HttpStatus.OK);
    }

    @GetMapping("/history-by-staff/{staffId}")
    public ResponseEntity getFunctionalStructureAssignationHistoryByStaff(@PathVariable("staffId") String staffId){
        return new ResponseEntity<Response>(Response.ok().setPayload(functionalStructureAssignationHistoryService.getFunctionalStructureAssignationHistoryByStaff(staffId)), HttpStatus.OK);

    }

    @GetMapping("/history-by-level/{levelId}")
    public ResponseEntity getFunctionalStructureAssignationHistoryByLevel(@PathVariable("levelId") String levelId){
        return new ResponseEntity<Response>(Response.ok().setPayload(functionalStructureAssignationHistoryService.getFunctionalStructureAssignationHistoryByLevel(levelId)), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{functionalStructureAssignationHistoryId}")
    public ResponseEntity deleteFunctionalStructureAssignationHistory(@PathVariable("functionalStructureAssignationHistoryId") String functionalStructureAssignationHistoryId){
        functionalStructureAssignationHistoryService.deleteFunctionalStructureAssignationHistory(functionalStructureAssignationHistoryId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(EntityType.FunctionalStructureAssignationHistory, DELETED)), HttpStatus.OK);

    }

    
}
