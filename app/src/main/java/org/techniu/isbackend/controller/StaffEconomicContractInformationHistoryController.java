package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;
import org.techniu.isbackend.service.StaffEconomicContractInformationHistoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffEconomicContractInformationHistoryController {
    private StaffEconomicContractInformationHistoryService staffEconomicContractInformationHistoryService;
    StaffEconomicContractInformationHistoryController(StaffEconomicContractInformationHistoryService staffEconomicContractInformationHistoryService){
        this.staffEconomicContractInformationHistoryService = staffEconomicContractInformationHistoryService;
    }

    @RequestMapping(path = "staffEconomicContractInformationHistory-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffEconomicContractInformationHistory saveStaffEconomicContractInformationHistory(@RequestBody StaffEconomicContractInformationHistory staffEconomicContractInformationHistory) {
        return staffEconomicContractInformationHistoryService.saveStaffEconomicContractInformationHistory(staffEconomicContractInformationHistory);
    }

    @RequestMapping(path = "staffEconomicContractInformationHistory-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffEconomicContractInformationHistory> getAllStaffEconomicContractInformationHistory(){
        return staffEconomicContractInformationHistoryService.getAllStaffEconomicContractInformationHistory();
    }

    @RequestMapping(path = "staffEconomicContractInformationHistory/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffEconomicContractInformationHistory> getStaffEconomicContractInformationHistoryByStaff(@PathVariable("id") String id){
        return staffEconomicContractInformationHistoryService.getStaffEconomicContractInformationHistoryByStaff(id);
    }

    @RequestMapping(path = "staffEconomicContractInformationHistory-update/{staffEconomicContractInformationHistoryId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff updateStaffEconomicContractInformationHistory(@PathVariable("staffEconomicContractInformationHistoryId") String staffEconomicContractInformationHistoryId, @RequestBody StaffEconomicContractInformationHistory staffEconomicContractInformationHistory){
        return staffEconomicContractInformationHistoryService.updateStaffEconomicContractInformationHistory(staffEconomicContractInformationHistoryId, staffEconomicContractInformationHistory);
    }

    @RequestMapping(path = "staffEconomicContractInformationHistory-delete/{staffEconomicContractInformationHistoryId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStaffEconomicContractInformationHistory(@PathVariable("staffEconomicContractInformationHistoryId") String staffEconomicContractInformationHistoryId){
        staffEconomicContractInformationHistoryService.deleteStaffEconomicContractInformationHistory(staffEconomicContractInformationHistoryId);
    }

    
}
