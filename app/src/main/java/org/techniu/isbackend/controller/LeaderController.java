package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Leader;
import org.techniu.isbackend.service.LeaderService;

import java.util.List;
@RestController
@CrossOrigin("*")
public class LeaderController {
    private LeaderService leaderService;
    LeaderController(LeaderService leaderService){
        this.leaderService = leaderService;
    }
    @RequestMapping(path = "leader",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Leader saveLeader(@RequestBody Leader leader){
        return leaderService.saveLeader(leader) ;
    }

    @RequestMapping(path = "leaders",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Leader> getLeaders(){
        return leaderService.getAllLeader();
    }
}
