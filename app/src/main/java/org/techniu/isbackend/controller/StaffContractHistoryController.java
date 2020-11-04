package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffContractHistory;
import org.techniu.isbackend.service.StaffContractHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffContractHistoryController {
    private StaffContractHistoryService staffContractHistoryService;
    StaffContractHistoryController(StaffContractHistoryService staffContractHistoryService){
        this.staffContractHistoryService = staffContractHistoryService;
    }

    @RequestMapping(path = "staffContractHistory-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffContractHistory saveStaffContractHistory(@RequestBody StaffContractHistory staffContractHistory) {
        return staffContractHistoryService.saveStaffContractHistory(staffContractHistory);
    }

    @RequestMapping(path = "staffContractHistory-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffContractHistory> getAllStaffContractHistory(){
        return staffContractHistoryService.getAllStaffContractHistory();
    }

    @RequestMapping(path = "staffContractHistory/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffContractHistory> getStaffContractHistoryByStaff(@PathVariable("id") String id){
        return staffContractHistoryService.getStaffContractHistoryByStaff(id);
    }

    @RequestMapping(path = "staffContractHistory-update/{staffContractHistoryId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff updateStaffContractHistory(@PathVariable("staffContractHistoryId") String staffContractHistoryId, @RequestBody StaffContractHistory staffContractHistory){
        return staffContractHistoryService.updateStaffContractHistory(staffContractHistoryId, staffContractHistory);
    }

    @RequestMapping(path = "staffContractHistory-delete/{staffContractHistoryId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStaffContractHistory(@PathVariable("staffContractHistoryId") String staffContractHistoryId){
        staffContractHistoryService.deleteStaffContractHistory(staffContractHistoryId);
    }

    
}
