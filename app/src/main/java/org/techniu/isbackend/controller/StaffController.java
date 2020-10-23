package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.service.StaffService;
import org.techniu.isbackend.service.StaffService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffController {
    private StaffService staffService;
    StaffController(StaffService  staffService){
        this.staffService = staffService;
    }

    @RequestMapping(path = "staff-add",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Staff saveStaff(@RequestPart("staff") Staff staff, @RequestPart("city") City city, @RequestPart("staffEconomicContractInformation") StaffEconomicContractInformation staffEconomicContractInformation, @RequestPart("staffContract") StaffContract staffContract,
                           @RequestPart("files[]") List<MultipartFile> staffDocuments, @RequestPart("staffDocumentsList") List<StaffDocuments> staffDocumentsList) throws IOException {
        //System.out.println(staff);
        for (int i = 0; i<staffDocumentsList.size(); i++) {
            staffDocumentsList.get(i).setDocument(staffDocuments.get(i).getBytes());
        }
        return staffService.saveStaff(staff, city, staffEconomicContractInformation, staffContract, staffDocumentsList);
    }

    @RequestMapping(path = "staff-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getStaff(){
        return staffService.getAllStaffs();
    }

    @RequestMapping(path = "staff-no-assigned",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getNotAssignedStaff(){
        return staffService.getAllNotAssignedStaffs();
    }

    @RequestMapping(path = "assign-level-staff",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void assignLevelToStaff(@RequestBody List<Object> objects){
        staffService.assignLevelToStaff(objects);
    }

    @RequestMapping(path = "get-staff-by-level/levelId={levelId}&isLeader={isLeader}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> getStaffsByLevel(@PathVariable("levelId") String levelId, @PathVariable("isLeader") String isLeader){
        return staffService.getStaffsByLevel(levelId, isLeader);
    }
}
