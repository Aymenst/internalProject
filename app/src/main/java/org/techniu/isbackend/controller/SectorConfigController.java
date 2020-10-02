package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.SectorConfig;
import org.techniu.isbackend.service.SectorConfigService;

import java.util.List;
@RestController
@CrossOrigin("*")
public class SectorConfigController {
    private SectorConfigService sectorConfigService;
    SectorConfigController(SectorConfigService sectorConfigService){
        this.sectorConfigService = sectorConfigService;
    }
    @RequestMapping(path = "sector-config",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public SectorConfig saveSectorConfig(@RequestBody SectorConfig sectorConfig){
        return sectorConfigService.saveSectorConfig(sectorConfig) ;
    }

    @RequestMapping(path = "sectors-config",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectorConfig> getSectorsConfig(){
        return sectorConfigService.getAllSectorConfig();
    }

    @RequestMapping(path = "sectors-config-primary/{name}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SectorConfig> getSectorsConfigByPrimary(@PathVariable(value = "name") String name){
        return sectorConfigService.getSectorConfigByPrimarySector(name);
    }
}
