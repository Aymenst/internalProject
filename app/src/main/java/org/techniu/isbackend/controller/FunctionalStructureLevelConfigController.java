package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.FunctionalStructureLevelConfig;
import org.techniu.isbackend.service.FunctionalStructureLevelConfigService;
import org.techniu.isbackend.service.FunctionalStructureLevelConfigService;

import java.util.List;

@RestController
@CrossOrigin("/api/levelConfig")
public class FunctionalStructureLevelConfigController {
    private FunctionalStructureLevelConfigService levelConfigService;
    FunctionalStructureLevelConfigController(FunctionalStructureLevelConfigService levelConfigService){
        this.levelConfigService = levelConfigService;
    }
    @RequestMapping(path = "level-config/save",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public FunctionalStructureLevelConfig saveLevelConfig(@RequestBody FunctionalStructureLevelConfig sectorConfig){
        return levelConfigService.saveLevelConfig(sectorConfig) ;
    }

    @RequestMapping(path = "levels-config",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevelConfig> getLevelsConfig(){
        return levelConfigService.getAllLevelConfig();
    }

    @RequestMapping(path = "levels-config-level1/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevelConfig> getLevelsConfigByLevel1(@PathVariable(value = "name") String name){
        return levelConfigService.getLevelConfigByLevel1(name);
    }

    @RequestMapping(path = "levels-config-level2/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevelConfig> getLevelsConfigByLevel2(@PathVariable(value = "name") String name){
        return levelConfigService.getLevelConfigByLevel2(name);
    }

    @RequestMapping(path = "levels-config-level3/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FunctionalStructureLevelConfig> getLevelsConfigByLevel3(@PathVariable(value = "name") String name){
        return levelConfigService.getLevelConfigByLevel3(name);
    }
}
