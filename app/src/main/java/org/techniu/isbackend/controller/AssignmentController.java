package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.service.AssignmentService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AssignmentController {
    private AssignmentService assignmentService;
    AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @RequestMapping(path = "assignment",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Assignment saveAssignment(@RequestBody Assignment assignment){
        return assignmentService.saveAssignment(assignment) ;
    }

    @RequestMapping(path = "client/assignment/{clientId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Assignment> getAssignmentByClient(@PathVariable(value = "clientId") String clientId){
        return assignmentService.getAssignmentByClient(clientId);
    }

    @RequestMapping(path = "client/assignment/people/{peopleId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Assignment> getAssignmentByPeople(@PathVariable(value = "peopleId") String peopleId){
        return assignmentService.getAssignmentByPeople(peopleId);
    }
}
