package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.StaffClientAssignmentAddrequest;
import org.techniu.isbackend.dto.mapper.StaffClientAssignmentMapper;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.AssignmentService;
import org.techniu.isbackend.service.StaffClientAssignmentService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.CommercialOperationStatus;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/assignment")
@CrossOrigin("*")
public class StaffClientAssignmentController {
    private StaffClientAssignmentService staffClientAssignmentService;
    private final MapValidationErrorService mapValidationErrorService;
    private final StaffClientAssignmentMapper staffClientAssignmentMapper = Mappers.getMapper(StaffClientAssignmentMapper.class);
    StaffClientAssignmentController(AssignmentService assignmentService, StaffClientAssignmentService staffClientAssignmentService, MapValidationErrorService mapValidationErrorService){
        this.staffClientAssignmentService = staffClientAssignmentService;
        this.mapValidationErrorService = mapValidationErrorService;
    }
    /*@RequestMapping(path = "assignment",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Assignment saveAssignment(@RequestBody Assignment assignment){
        return staffClientAssignmentService.saveAssignment(assignment) ;
    }*/


    @PostMapping("/assine2")
    public ResponseEntity add(@RequestBody @Valid StaffClientAssignmentAddrequest staffClientAssignmentAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save Assignment
        staffClientAssignmentService.save(staffClientAssignmentMapper.addRequestToDto(staffClientAssignmentAddrequest),staffClientAssignmentAddrequest.getStaffId(),staffClientAssignmentAddrequest.getClientIds());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CommercialOperationStatus, ADDED)), HttpStatus.OK);
    }

/*
    @RequestMapping(path = "client/assignment/{clientId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Assignment> getAssignmentByClient(@PathVariable(value = "clientId") String clientId){
        return staffClientAssignmentService.getAssignmentByClient(clientId);
    }

    @RequestMapping(path = "client/assignment/people/{peopleId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Assignment> getAssignmentByPeople(@PathVariable(value = "peopleId") String peopleId){
        return staffClientAssignmentService.getAssignmentByPeople(peopleId);
    }*/
}
