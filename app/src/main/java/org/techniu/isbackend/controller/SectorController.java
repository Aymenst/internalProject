package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Sector;
import org.techniu.isbackend.service.SectorService;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SectorController {
    private SectorService sectorService;
    SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }
    @RequestMapping(path = "sector",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Sector saveSector(@RequestBody Sector sector){
        return sectorService.saveSector(sector) ;
    }

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
    }
}
