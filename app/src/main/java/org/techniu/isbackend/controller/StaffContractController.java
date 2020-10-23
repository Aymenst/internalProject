package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.techniu.isbackend.entity.StaffContract;
import org.techniu.isbackend.service.StaffContractService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StaffContractController {
    private StaffContractService staffContractService;
    StaffContractController(StaffContractService staffContractService){
        this.staffContractService = staffContractService;
    }

    @RequestMapping(path = "staffContract-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffContract saveStaffContract(@RequestPart("staffContract") StaffContract staffContract, @RequestPart("files[]") List<MultipartFile> multipartFiles) throws IOException {
        staffContract.setContractDoc(multipartFiles.get(0).getBytes());
        staffContract.setInternalRulesDoc(multipartFiles.get(1).getBytes());
        staffContract.setPreContractDoc(multipartFiles.get(2).getBytes());
        return staffContractService.saveStaffContract(staffContract);
    }

    @RequestMapping(path = "staffContract-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffContract> getAllStaffContracts(){
        return staffContractService.getAllStaffContracts();
    }

    @RequestMapping(path = "staffContract-update/{staffContractId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffContract updateStaffContract(@PathVariable("staffContractId") String staffContractId, @RequestBody StaffContract staffContract){
        return staffContractService.updateStaffContract(staffContractId, staffContract);
    }

    @RequestMapping(path = "staffContract-delete/{staffContractId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStaffContract(@PathVariable("staffContractId") String staffContractId){
        staffContractService.deleteStaffContract(staffContractId);
    }

    
}
