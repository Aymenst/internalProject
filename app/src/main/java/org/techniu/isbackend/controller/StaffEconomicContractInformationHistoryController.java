package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.service.StaffEconomicContractInformationHistoryService;

import java.util.List;

import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/staffEconomicContractInformationHistory")
@CrossOrigin("*")
public class StaffEconomicContractInformationHistoryController {
    private StaffEconomicContractInformationHistoryService staffEconomicContractInformationHistoryService;
    StaffEconomicContractInformationHistoryController(StaffEconomicContractInformationHistoryService staffEconomicContractInformationHistoryService){
        this.staffEconomicContractInformationHistoryService = staffEconomicContractInformationHistoryService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllStaffEconomicContractInformationHistory(){
        return new ResponseEntity<Response>(Response.ok().setPayload(staffEconomicContractInformationHistoryService.getAllStaffEconomicContractInformationHistory()), HttpStatus.OK);
    }

    @GetMapping("/history-by-staff/{staffEconomicContractInformationId}")
    public ResponseEntity getStaffEconomicContractInformationHistoryByStaff(@PathVariable("staffEconomicContractInformationId") String staffEconomicContractInformationId){
        return new ResponseEntity<Response>(Response.ok().setPayload(staffEconomicContractInformationHistoryService.getStaffEconomicContractInformationHistoryByStaffEconomicContractInformation(staffEconomicContractInformationId)), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{staffEconomicContractInformationHistoryId}")
    public ResponseEntity deleteStaffEconomicContractInformationHistory(@PathVariable("staffEconomicContractInformationHistoryId") String staffEconomicContractInformationHistoryId){
        staffEconomicContractInformationHistoryService.deleteStaffEconomicContractInformationHistory(staffEconomicContractInformationHistoryId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(EntityType.StaffEconomicContractInformationHistory, DELETED)), HttpStatus.OK);

    }



}
