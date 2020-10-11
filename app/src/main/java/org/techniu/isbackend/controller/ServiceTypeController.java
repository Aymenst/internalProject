package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.ServiceTypeAddrequest;
import org.techniu.isbackend.controller.request.ServiceTypeUpdaterequest;
import org.techniu.isbackend.dto.mapper.ServiceTypeMapper;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ServiceTypeService;

import javax.validation.Valid;

import static org.techniu.isbackend.exception.EntityType.ServiceType;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/serviceType")
@CrossOrigin("*")
public class ServiceTypeController {
    private final ServiceTypeService serviceTypeService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ServiceTypeMapper serviceTypeMapper = Mappers.getMapper(ServiceTypeMapper.class);
    public ServiceTypeController(ServiceTypeService serviceTypeService, MapValidationErrorService mapValidationErrorService) {
        this.serviceTypeService = serviceTypeService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ServiceTypeAddrequest serviceTypeAddrequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save staff
        serviceTypeService.save(serviceTypeMapper.addRequestToDto(serviceTypeAddrequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ServiceType, ADDED)), HttpStatus.OK);
    }
    /**
     * Handles the incoming POST API "/serviceType/update"
     *
     * @param serviceTypeUpdaterequest Action update
     * @return Response
     */
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody @Valid ServiceTypeUpdaterequest serviceTypeUpdaterequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        serviceTypeService.update(serviceTypeMapper.updateRequestToDto(serviceTypeUpdaterequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(
                getMessageTemplate(ServiceType, UPDATED)), HttpStatus.OK);
    }

    /**
     * Handles the incoming DELETE API "/serviceType/delete"
     *
     * @param id action delete request
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        serviceTypeService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(ServiceType, DELETED)), HttpStatus.OK);
    }

    /**
     * display all serviceType GET API "/api/serviceType"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allServiceType() {
        return new ResponseEntity<Response>(Response.ok().setPayload(serviceTypeService.getAll()), HttpStatus.OK);
    }
}
