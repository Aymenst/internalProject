package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.ContractType;
import org.techniu.isbackend.service.ContractTypeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ContractTypeController {
    private ContractTypeService contractTypeService;
    ContractTypeController(ContractTypeService contractTypeService){
        this.contractTypeService = contractTypeService;
    }
    @RequestMapping(path = "contractType-save/{stateCountryId}",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractType saveContractType(@RequestBody ContractType contractType, @PathVariable("stateCountryId") String stateCountryId ){
        return contractTypeService.saveContractType(contractType, stateCountryId) ;
    }

    @RequestMapping(path = "contractType-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContractType> getAllContractTypes(){
        return contractTypeService.getAllContractTypes();
    }

    @RequestMapping(path = "contractType-all-by-state/{stateCountryId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContractType> getAllByState(@PathVariable("stateCountryId") String stateCountryId){
        return contractTypeService.getAllByState(stateCountryId);
    }

    @RequestMapping(path = "contractType-update/{contractTypeId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractType updateContractType(@PathVariable("contractTypeId") String contractTypeId, @RequestBody ContractType contractType){
        return contractTypeService.updateContractType(contractTypeId, contractType);
    }

    @RequestMapping(path = "contractType-delete/{contractTypeId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteContractType(@PathVariable("contractTypeId") String contractTypeId){
        contractTypeService.deleteContractType(contractTypeId);
    }


}
