package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.LegalCategoryType;
import org.techniu.isbackend.service.LegalCategoryTypeService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LegalCategoryTypeController {
    private LegalCategoryTypeService legalCategoryTypeService;
    LegalCategoryTypeController(LegalCategoryTypeService legalCategoryTypeService){
        this.legalCategoryTypeService = legalCategoryTypeService;
    }
    @RequestMapping(path = "legalCategoryType-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public LegalCategoryType saveLegalCategoryType(@RequestBody LegalCategoryType legalCategoryType){
        return legalCategoryTypeService.saveLegalCategoryType(legalCategoryType) ;
    }

    @RequestMapping(path = "legalCategoryType-all",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LegalCategoryType> getAllLegalCategoryTypes(){
        return legalCategoryTypeService.getAllLegalCategoryTypes();
    }

    @RequestMapping(path = "legalCategoryType-by-company/{companyName}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LegalCategoryType> getAllLegalCategoryTypesByCompany(@PathVariable("companyName") String companyName){
        return legalCategoryTypeService.getAllLegalCategoryTypesByCompany(companyName);
    }

    @RequestMapping(path = "legalCategoryType-update/{legalCategoryTypeId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public LegalCategoryType updateLegalCategoryType(@PathVariable("legalCategoryTypeId") String legalCategoryTypeId, @RequestBody LegalCategoryType legalCategoryType){
        return legalCategoryTypeService.updateLegalCategoryType(legalCategoryTypeId, legalCategoryType);
    }

    @RequestMapping(path = "legalCategoryType-delete/{legalCategoryTypeId}",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteLegalCategoryType(@PathVariable("legalCategoryTypeId") String legalCategoryTypeId){
        legalCategoryTypeService.deleteLegalCategoryType(legalCategoryTypeId);
    }


}
