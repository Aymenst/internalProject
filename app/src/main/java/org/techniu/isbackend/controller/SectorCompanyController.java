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
        // Sector1
        SectorCompany sectorCompany1=new SectorCompany();
        sectorCompany1.setName(sectorCompanyAddrequest.getFirstSectorName());
        sectorCompany1.setDescription(sectorCompanyAddrequest.getFirstSectorDescription());
        sectorCompany1.setParent(null);
        sectorCompany1.setStaff(null);
        // Sector2
        SectorCompany sectorCompany2=new SectorCompany();
        sectorCompany2.setName(sectorCompanyAddrequest.getSecondSectorName());
        sectorCompany2.setDescription(sectorCompanyAddrequest.getSecondSectorDescription());
        sectorCompany2.setParent(sectorCompanyService.save(sectorCompany1));
        // Sector3
        SectorCompany sectorCompany3=new SectorCompany();
        sectorCompany3.setName(sectorCompanyAddrequest.getThirdSectorName());
        sectorCompany3.setDescription(sectorCompanyAddrequest.getThirdSectorDescription());
        sectorCompany3.setParent(sectorCompanyService.save(sectorCompany2));
        sectorCompanyService.save(sectorCompany3);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(SectorCompany, ADDED)), HttpStatus.OK);
    }
    /**
     * display all SectorCompany GET API "/api/SectorCompany"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allSectorCompany() {
        return new ResponseEntity<Response>(Response.ok().setPayload(sectorCompanyService.getAll()), HttpStatus.OK);
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
