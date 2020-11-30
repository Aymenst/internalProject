package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffContractHistory;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.service.StaffContractHistoryService;

import java.util.List;

import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.ExceptionType.UPDATED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/staffContractHistory")
@CrossOrigin("*")
public class StaffContractHistoryController {
    private StaffContractHistoryService staffContractHistoryService;
    StaffContractHistoryController(StaffContractHistoryService staffContractHistoryService){
        this.staffContractHistoryService = staffContractHistoryService;
    }


    @GetMapping("/all")
    public ResponseEntity getAllStaffContractHistory(){
        return new ResponseEntity<Response>(Response.ok().setPayload(staffContractHistoryService.getAllStaffContractHistory()), HttpStatus.OK);
    }

    @GetMapping("/history-by-staff/{staffContractId}")
    public ResponseEntity getStaffContractHistoryByStaff(@PathVariable("staffContractId") String staffContractId){
        return new ResponseEntity<Response>(Response.ok().setPayload(staffContractHistoryService.getStaffContractHistoryByStaffContract(staffContractId)), HttpStatus.OK);

    }


    @DeleteMapping("/delete/{staffContractHistoryId}")
    public ResponseEntity deleteStaffContractHistory(@PathVariable("staffContractHistoryId") String staffContractHistoryId){
        staffContractHistoryService.deleteStaffContractHistory(staffContractHistoryId);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(EntityType.StaffContractHistory, DELETED)), HttpStatus.OK);

    }

    
}
