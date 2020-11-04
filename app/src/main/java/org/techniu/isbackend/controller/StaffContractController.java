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

    @RequestMapping(path = "staffContract-save/contractTypeId={contractTypeId}&legalCategoryTypeId={legalCategoryTypeId}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffContract saveStaffContract(@RequestPart("staffContract") StaffContract staffContract, @RequestPart("contractDoc") MultipartFile contractDoc, @RequestPart("internalRulesDoc") MultipartFile internalRulesDoc, @RequestPart("preContractDoc") MultipartFile preContractDoc,
                                           @PathVariable("contractTypeId") String contractTypeId, @PathVariable("legalCategoryTypeId") String legalCategoryTypeId) throws IOException {
        if(contractDoc.getContentType().equals("application/pdf")) {
            staffContract.setContractDoc(contractDoc.getBytes());
            System.out.println("set contract doc");
        };
        if(internalRulesDoc.getContentType().equals("application/pdf")) {
            staffContract.setInternalRulesDoc(internalRulesDoc.getBytes());
            System.out.println("set internal doc");
        };
        if(internalRulesDoc.getContentType().equals("application/pdf")) {
            staffContract.setPreContractDoc(preContractDoc.getBytes());
            System.out.println("set contract doc");
        };
        return staffContractService.saveStaffContract(staffContract, contractTypeId,legalCategoryTypeId );
    }

    @RequestMapping(path = "staffContract-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffContract> getAllStaffContracts(){
        return staffContractService.getAllStaffContracts();
    }

    @RequestMapping(path = "staffContract-update/id={staffContractId}&contractTypeId={contractTypeId}&legalCategoryTypeId={legalCategoryTypeId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public StaffContract updateStaffContract(@RequestPart("staffContract") StaffContract staffContract, @RequestPart("contractDoc") MultipartFile contractDoc, @RequestPart("internalRulesDoc") MultipartFile internalRulesDoc, @RequestPart("preContractDoc") MultipartFile preContractDoc,
                                             @PathVariable("staffContractId") String staffContractId, @PathVariable("contractTypeId") String contractTypeId, @PathVariable("legalCategoryTypeId") String legalCategoryTypeId) throws IOException {

        if(contractDoc.getContentType().equals("application/pdf")) {
            staffContract.setContractDoc(contractDoc.getBytes());
            System.out.println("set contract doc");
        };
        if(internalRulesDoc.getContentType().equals("application/pdf")) {
            staffContract.setInternalRulesDoc(internalRulesDoc.getBytes());
            System.out.println("set internal doc");
        };
        if(internalRulesDoc.getContentType().equals("application/pdf")) {
            staffContract.setPreContractDoc(preContractDoc.getBytes());
            System.out.println("set contract doc");
        };
        return staffContractService.updateStaffContract(staffContractId, staffContract, contractTypeId,legalCategoryTypeId );
    }

    @RequestMapping(path = "staffContract-delete/{staffContractId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteStaffContract(@PathVariable("staffContractId") String staffContractId){
        staffContractService.deleteStaffContract(staffContractId);
    }


}
