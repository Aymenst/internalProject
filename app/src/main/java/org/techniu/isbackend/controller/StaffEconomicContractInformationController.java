package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.service.StaffEconomicContractInformationService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffEconomicContractInformationController {
    private StaffEconomicContractInformationService staffEconomicContractInformationService;
    StaffEconomicContractInformationController(StaffEconomicContractInformationService staffEconomicContractInformationService){
        this.staffEconomicContractInformationService = staffEconomicContractInformationService;
    }

    @RequestMapping(path = "staffEconomicContractInformation-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffEconomicContractInformation saveStaffEconomicContractInformation(@RequestBody StaffEconomicContractInformation staffEconomicContractInformation) {
        return staffEconomicContractInformationService.saveStaffEconomicContractInformation(staffEconomicContractInformation);
    }

    @RequestMapping(path = "staffEconomicContractInformation-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffEconomicContractInformation> getAllStaffEconomicContractInformation(){
        return staffEconomicContractInformationService.getAllStaffEconomicContractInformation();
    }

    @RequestMapping(path = "staffEconomicContractInformation-update/{staffEconomicContractInformationId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffEconomicContractInformation updateStaffEconomicContractInformation(@PathVariable("staffEconomicContractInformationId") String staffEconomicContractInformationId, @RequestBody StaffEconomicContractInformation staffEconomicContractInformation){
        return staffEconomicContractInformationService.updateStaffEconomicContractInformation(staffEconomicContractInformationId, staffEconomicContractInformation);
    }

    @RequestMapping(path = "staffEconomicContractInformation-delete/{staffEconomicContractInformationId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStaffEconomicContractInformation(@PathVariable("staffEconomicContractInformationId") String staffEconomicContractInformationId){
        staffEconomicContractInformationService.deleteStaffEconomicContractInformation(staffEconomicContractInformationId);
    }

    
}
