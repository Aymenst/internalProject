package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.AdministrativeStructureLevelUpdaterequest;
import org.techniu.isbackend.dto.mapper.AdministrativeStructureLevelMapper;
import org.techniu.isbackend.entity.AdministrativeStructureLevel;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.AdministrativeStructureLevelService;

import java.util.List;

import static org.techniu.isbackend.exception.EntityType.AdministrativeStructureLevel;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/administrativeStructure")
@CrossOrigin("*")
public class AdministrativeStructureLevelController {
    private AdministrativeStructureLevelService administrativeStructureLevelService;

    private final MapValidationErrorService mapValidationErrorService;
    private final AdministrativeStructureLevelMapper administrativeStructureLevelMapper = Mappers.getMapper(AdministrativeStructureLevelMapper.class);

    AdministrativeStructureLevelController(AdministrativeStructureLevelService administrativeStructureLevelService, MapValidationErrorService mapValidationErrorService){
        this.administrativeStructureLevelService = administrativeStructureLevelService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody List<Object> objects, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save AdministrativeStructureLevel
        administrativeStructureLevelService.save(objects) ;
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AdministrativeStructureLevel, ADDED)), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllAdministrativeStructureLevels(){
        return new ResponseEntity<Response>(Response.ok().setPayload(administrativeStructureLevelService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/all-by-type/{type}")
    public ResponseEntity getAllByType(@PathVariable("type") String type){
        return new ResponseEntity<Response>(Response.ok().setPayload(administrativeStructureLevelService.getAllByType(type)), HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody AdministrativeStructureLevelUpdaterequest administrativeStructureLevelUpdaterequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        administrativeStructureLevelService.update(administrativeStructureLevelMapper.updateRequestToDto(administrativeStructureLevelUpdaterequest), administrativeStructureLevelUpdaterequest.getOldLeaderId(), administrativeStructureLevelUpdaterequest.getNewLeaderId());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AdministrativeStructureLevel, UPDATED)), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        administrativeStructureLevelService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AdministrativeStructureLevel, DELETED)), HttpStatus.OK);
    }

    @GetMapping("/level-tree/{levelId}")
    public List<AdministrativeStructureLevel> getAdministrativeStructureTree(@PathVariable(value = "levelId") String levelId){
        return administrativeStructureLevelService.getAdministrativeStructureTree(levelId);
    }

    @GetMapping("/level-name/{name}")
    public AdministrativeStructureLevel getLevelByName(@PathVariable(value = "name") String name){
        return administrativeStructureLevelService.getLevelByName(name);
    }



    @PostMapping("/level-assign")
    public ResponseEntity setLevelStaffs(@RequestBody List<Object> objects){
         administrativeStructureLevelService.setLevelStaffs(objects) ;
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(AdministrativeStructureLevel, ASSIGNED_LEVEL_STAFF)), HttpStatus.OK);

    }
}

