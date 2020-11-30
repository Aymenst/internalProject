package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.service.AdministrativeStructureAssignationHistoryService;

import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/administrativeStructureAssignationHistory")
@CrossOrigin("*")
public class AdministrativeStructureAssignationHistoryController {
    private AdministrativeStructureAssignationHistoryService administrativeStructureAssignationHistoryService;
    AdministrativeStructureAssignationHistoryController(AdministrativeStructureAssignationHistoryService administrativeStructureAssignationHistoryService){
        this.administrativeStructureAssignationHistoryService = administrativeStructureAssignationHistoryService;
    }


    @GetMapping("/all")
    public ResponseEntity getAllAdministrativeStructureAssignationHistory(){
        return new ResponseEntity<Response>(Response.ok().setPayload(administrativeStructureAssignationHistoryService.getAllAdministrativeStructureAssignationHistory()), HttpStatus.OK);
    }

    @GetMapping("/history-by-staff/{staffId}")
    public ResponseEntity getAdministrativeStructureAssignationHistoryByStaff(@PathVariable("staffId") String staffId){
        return new ResponseEntity<Response>(Response.ok().setPayload(administrativeStructureAssignationHistoryService.getAdministrativeStructureAssignationHistoryByStaff(staffId)), HttpStatus.OK);

    }

    @GetMapping("/history-by-level/{levelId}")
    public ResponseEntity getAdministrativeStructureAssignationHistoryByLevel(@PathVariable("levelId") String levelId){
        return new ResponseEntity<Response>(Response.ok().setPayload(administrativeStructureAssignationHistoryService.getAdministrativeStructureAssignationHistoryByLevel(levelId)), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{administrativeStructureAssignationHistoryId}")
    public ResponseEntity deleteAdministrativeStructureAssignationHistory(@PathVariable("administrativeStructureAssignationHistoryId") String administrativeStructureAssignationHistoryId){
        administrativeStructureAssignationHistoryService.deleteAdministrativeStructureAssignationHistory(administrativeStructureAssignationHistoryId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(EntityType.AdministrativeStructureAssignationHistory, DELETED)), HttpStatus.OK);

    }

    
}
