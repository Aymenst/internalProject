package org.techniu.isbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.SectorCompanyAddrequest;
import org.techniu.isbackend.entity.SectorCompany;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.SectorCompanyService;


import javax.validation.Valid;

import static org.techniu.isbackend.exception.EntityType.CommercialOperationStatus;
import static org.techniu.isbackend.exception.EntityType.SectorCompany;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/SectorCompany")
@CrossOrigin("*")
public class SectorCompanyController {
    private SectorCompanyService sectorCompanyService;
    private final MapValidationErrorService mapValidationErrorService;
    SectorCompanyController(SectorCompanyService sectorCompanyService, MapValidationErrorService mapValidationErrorService) {
        this.sectorCompanyService = sectorCompanyService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid SectorCompanyAddrequest sectorCompanyAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save CommercialOperationStatus

        SectorCompany sectorCompany1 = new SectorCompany();
        SectorCompany sectorCompany2=new SectorCompany();
        SectorCompany sectorCompany3=new SectorCompany();
        // chek if Sector1 exist
        SectorCompany sectorCompanyparent1 = sectorCompanyService.checkIfSectorExist(sectorCompanyAddrequest.getFirstSectorName());
        //not existe create sector1
        if (sectorCompanyparent1 == null){
        sectorCompany1.setName(sectorCompanyAddrequest.getFirstSectorName());
        sectorCompany1.setDescription(sectorCompanyAddrequest.getFirstSectorDescription());
        sectorCompany1.setParent(null);
        sectorCompany1.setStaff(null);

        sectorCompany2.setParent(sectorCompanyService.save(sectorCompany1));
        sectorCompany2.setName(sectorCompanyAddrequest.getSecondSectorName());
        sectorCompany2.setDescription(sectorCompanyAddrequest.getSecondSectorDescription());

        sectorCompany3.setName(sectorCompanyAddrequest.getThirdSectorName());
        sectorCompany3.setDescription(sectorCompanyAddrequest.getThirdSectorDescription());

            if(sectorCompanyAddrequest.getSecondSectorName()!=null && sectorCompanyAddrequest.getSecondSectorName() !=""){
        sectorCompany3.setParent(sectorCompanyService.save(sectorCompany2));}
            if(sectorCompanyAddrequest.getThirdSectorName()!=null && sectorCompanyAddrequest.getThirdSectorName() !="") {
                sectorCompanyService.save(sectorCompany3);
            }
        }

        else {
            // chek if Sector2 exist
            SectorCompany sectorCompanyparent2 = sectorCompanyService.checkIfSectorExist(sectorCompanyAddrequest.getSecondSectorName());
            //not existe create sector2
            if (sectorCompanyparent2 == null && sectorCompanyAddrequest.getSecondSectorName() !=null) {
                sectorCompany2.setName(sectorCompanyAddrequest.getSecondSectorName());
                sectorCompany2.setDescription(sectorCompanyAddrequest.getSecondSectorDescription());
                sectorCompany2.setParent(sectorCompanyparent1);
                sectorCompany3.setName(sectorCompanyAddrequest.getThirdSectorName());
                sectorCompany3.setDescription(sectorCompanyAddrequest.getThirdSectorDescription());
                sectorCompany3.setParent(sectorCompanyService.save(sectorCompany2));
                sectorCompanyService.save(sectorCompany3);
            }
            else{
                if (sectorCompanyAddrequest.getSecondSectorName() !=null) {
                    sectorCompany3.setParent(sectorCompanyparent2);
                    sectorCompany3.setName(sectorCompanyAddrequest.getThirdSectorName());
                    sectorCompany3.setDescription(sectorCompanyAddrequest.getThirdSectorDescription());
                    sectorCompanyService.save(sectorCompany3);
                }
            }
        }
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(SectorCompany, ADDED)), HttpStatus.OK);
    }
    /**
     * display all SectorCompany GET API "/api/SectorCompany"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allSectorCompany() {
        return new ResponseEntity<Response>(Response.ok().setPayload(sectorCompanyService.getAll()), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/primarySector")
    public ResponseEntity getSectorsPrimary(){
        return new ResponseEntity<Response>(Response.ok().setPayload(sectorCompanyService.getSectorsPrimary()), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/sectorByParent/{parentName}")
    public ResponseEntity sectorByParent(@PathVariable(value = "parentName") String parentName){
        return new ResponseEntity<Response>(Response.ok().setPayload(sectorCompanyService.getAllBysectorByParent(parentName)), HttpStatus.OK);
    }
    // return all sub sector of primarysector
    @RequestMapping(method = RequestMethod.GET, value = "/allSectorByParent/{parentName}")
    public ResponseEntity allSectorByParent(@PathVariable(value = "parentName") String parentName){
        return new ResponseEntity<Response>(Response.ok().setPayload(sectorCompanyService.getAllSectorsByParent(parentName)), HttpStatus.OK);
    }

    /**
     * Handles the incoming DELETE API "/SectorCompany/deleteVerfication"
     *
     * @param firstSectorName action delete request
     * @param secondSectorName action delete request
     * @param thirdSectorName action delete request
     */
    @RequestMapping(value = "/deleteVerfication/{firstSectorName}/{secondSectorName}/{thirdSectorName}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String firstSectorName,@PathVariable String secondSectorName,@PathVariable String thirdSectorName) {
         sectorCompanyService.remove(firstSectorName,secondSectorName,thirdSectorName);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(SectorCompany, DELETED)), HttpStatus.OK);
    }

    /**
     * Handles the incoming DELETE API "/SectorCompany/deleteConfirmation"
     *
     * @param firstSectorName action delete request
     * @param secondSectorName action delete request
     * @param thirdSectorName action delete request
     */
    @RequestMapping(value = "/deleteConfirmation/{firstSectorName}/{secondSectorName}/{thirdSectorName}", method = RequestMethod.DELETE)
    public ResponseEntity deleteConfermation(@PathVariable String firstSectorName,@PathVariable String secondSectorName,@PathVariable String thirdSectorName) {
        sectorCompanyService.removeConfirmation(firstSectorName,secondSectorName,thirdSectorName);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(SectorCompany, DELETED)), HttpStatus.OK);
    }
/*
    @RequestMapping(path = "sectors",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sector> getSectors(){
        return sectorService.getAllSector();
    }
    @RequestMapping(path = "sectors-primary/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sector> getSectorsPrimary(@PathVariable(value = "name") String name){
        return sectorService.getSectorByPrimary(name);
    }

    @RequestMapping(path = "sectors-type/{type}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sector> getSectorsType(@PathVariable(value = "type") String type){
        return sectorService.getSectorByType(type);
    }*/
}
