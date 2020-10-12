package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.controller.request.CommercialOperationStatusUpdaterequest;
import org.techniu.isbackend.dto.mapper.CommercialOperationStatusMapper;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.CommercialOperationStatusService;


import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.CommercialOperationStatus;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.ExceptionType.UPDATED;
import static org.techniu.isbackend.exception.ExceptionType.DELETED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/commercialOperationStatus")
@CrossOrigin("*")
public class CommercialOperationStatusController {
    private final CommercialOperationStatusService commercialOperationStatusService;
    private final MapValidationErrorService mapValidationErrorService;
    private final CommercialOperationStatusMapper commercialOperationStatusMapper = Mappers.getMapper(CommercialOperationStatusMapper.class);
    public CommercialOperationStatusController(CommercialOperationStatusService commercialOperationStatusService, MapValidationErrorService mapValidationErrorService) {
        this.commercialOperationStatusService = commercialOperationStatusService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CommercialOperationStatusAddrequest commercialOperationStatusAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save CommercialOperationStatus
        System.out.println(commercialOperationStatusMapper.addRequestToDto(commercialOperationStatusAddrequest));
        commercialOperationStatusService.save(commercialOperationStatusMapper.addRequestToDto(commercialOperationStatusAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CommercialOperationStatus, ADDED)), HttpStatus.OK);
    }
    /**
     * Handles the incoming POST API "/commercialOperationStatus/update"
     *
     * @param commercialOperationStatusUpdaterequest Action update
     * @return Response
     */
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody @Valid CommercialOperationStatusUpdaterequest commercialOperationStatusUpdaterequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        commercialOperationStatusService.update(commercialOperationStatusMapper.updateRequestToDto(commercialOperationStatusUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(
                getMessageTemplate(CommercialOperationStatus, UPDATED)), HttpStatus.OK);
    }

    /**
     * Handles the incoming DELETE API "/commercialOperationStatus/delete"
     *
     * @param id action delete request
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        commercialOperationStatusService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CommercialOperationStatus, DELETED)), HttpStatus.OK);
    }

    /**
     * display all commercialOperationStatus GET API "/api/commercialOperationStatus"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allCommercialOperationStatus() {
        return new ResponseEntity<Response>(Response.ok().setPayload(commercialOperationStatusService.getAll()), HttpStatus.OK);
    }
}
