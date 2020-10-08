package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.dto.mapper.CommercialOperationStatusMapper;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.CommercialOperationStatusService;


import javax.validation.Valid;
import java.util.List;

import static org.techniu.isbackend.exception.EntityType.CommercialOperationStatus;
import static org.techniu.isbackend.exception.ExceptionType.ADDED;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/commercialOperationStatus")
public class CommercialOperationStatusController {
    private final CommercialOperationStatusService commercialOperationStatusService;
    private final MapValidationErrorService mapValidationErrorService;
    private final CommercialOperationStatusMapper commercialOperationStatusMapper = Mappers.getMapper(CommercialOperationStatusMapper.class);
    public CommercialOperationStatusController(CommercialOperationStatusService commercialOperationStatusService, MapValidationErrorService mapValidationErrorService) {
        this.commercialOperationStatusService = commercialOperationStatusService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    /**
     * display all commercialOperationStatus GET API "/api/commercialOperationStatus"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allCommercialOperationStatus() {
        return new ResponseEntity<Response>(Response.ok().setPayload(commercialOperationStatusService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CommercialOperationStatusAddrequest commercialOperationStatusAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save staff
        commercialOperationStatusService.save(commercialOperationStatusMapper.addRequestToDto(commercialOperationStatusAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CommercialOperationStatus, ADDED)), HttpStatus.OK);
    }

}
