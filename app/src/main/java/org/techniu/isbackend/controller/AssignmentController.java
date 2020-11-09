package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.AssignmentAddrequest;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.dto.mapper.AssignmentMapper;
import org.techniu.isbackend.dto.mapper.CommercialOperationStatusMapper;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.AssignmentService;

import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.CommercialOperation;
import static org.techniu.isbackend.exception.EntityType.CommercialOperationStatus;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.ExceptionType.UPDATED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/assignment")
@CrossOrigin("*")
public class AssignmentController {
    private AssignmentService assignmentService;
    private final MapValidationErrorService mapValidationErrorService;
    private final AssignmentMapper assignmentMapper = Mappers.getMapper(AssignmentMapper.class);
    AssignmentController(AssignmentService assignmentService, MapValidationErrorService mapValidationErrorService){
        this.assignmentService = assignmentService;
        this.mapValidationErrorService = mapValidationErrorService;
    }
    @RequestMapping(path = "assignment",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Assignment saveAssignment(@RequestBody Assignment assignment){
        return assignmentService.saveAssignment(assignment) ;
    }


    @PostMapping("/assine")
    public ResponseEntity add(@RequestBody @Valid AssignmentAddrequest assignmentAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save Assignment
        assignmentService.save(assignmentMapper.addRequestToDto(assignmentAddrequest),assignmentAddrequest.getStaffId(),assignmentAddrequest.getClientIds());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CommercialOperationStatus, ADDED)), HttpStatus.OK);
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
