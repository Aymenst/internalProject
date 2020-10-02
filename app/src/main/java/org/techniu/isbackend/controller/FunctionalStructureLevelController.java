package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.service.FunctionalStructureLevelService;

import java.util.List;

@RestController
@CrossOrigin("/api/level")
public class FunctionalStructureLevelController {
    private FunctionalStructureLevelService functionalStructureLevelService;
    FunctionalStructureLevelController(FunctionalStructureLevelService functionalStructureLevelService) {
        this.functionalStructureLevelService = functionalStructureLevelService;
    }
    @RequestMapping(path = "level-save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean saveLevel(@RequestBody List<Object> objects){
        return functionalStructureLevelService.saveLevel(objects) ;
    }

    @RequestMapping(path = "levels",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevel> getLevels(){
        return functionalStructureLevelService.getAllLevels();
    }
    @RequestMapping(path = "levels-parent/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevel> getLevelByParent(@PathVariable(value = "name") String name){
        return functionalStructureLevelService.getLevelByParent(name);
    }

    @RequestMapping(path = "levels-type/{type}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevel> getLevelByType(@PathVariable(value = "type") String type){
        return functionalStructureLevelService.getLevelByType(type);
    }

    @RequestMapping(path = "level-name/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FunctionalStructureLevel getLevelByName(@PathVariable(value = "name") String name){
        return functionalStructureLevelService.getLevelByName(name);
    }

    @RequestMapping(path = "level-assign",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Staff> setLevelStaffs(@RequestBody List<Object> objects){
        return functionalStructureLevelService.setLevelStaffs(objects) ;
    }
}

