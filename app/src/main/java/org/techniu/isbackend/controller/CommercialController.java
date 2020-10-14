package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Commercial;
import org.techniu.isbackend.service.CommercialService;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CommercialController {
    private CommercialService commercialService;
    CommercialController(CommercialService commercialService){
        this.commercialService = commercialService;
    }

    @RequestMapping(path = "commercial",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Commercial saveClient(@RequestBody Commercial commercial){
        return commercialService.saveCommercial(commercial) ;
    }

    @RequestMapping(path = "commercials",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Commercial> getCommercial(){
        return commercialService.getAllCommercial();
    }
}
