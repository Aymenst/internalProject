package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.CivilityTitleAddRequest;
import org.techniu.isbackend.controller.request.CivilityTitleUpdateRequest;
import org.techniu.isbackend.dto.mapper.CivilityTitleMapper;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.CivilityTitleService;

import javax.validation.Valid;

import static org.techniu.isbackend.exception.EntityType.CivilityTitle;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/civilityTitle")
@CrossOrigin("*")
public class CivilityTitleController {
    private final CivilityTitleService civilityTitleService;
    private final MapValidationErrorService mapValidationErrorService;
    private final CivilityTitleMapper civilityTitleMapper = Mappers.getMapper(CivilityTitleMapper.class);
    public CivilityTitleController(CivilityTitleService civilityTitleService, MapValidationErrorService mapValidationErrorService) {
        this.civilityTitleService = civilityTitleService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid CivilityTitleAddRequest civilityTitleAddRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save CivilityTitle
        System.out.println(civilityTitleMapper.addRequestToDto(civilityTitleAddRequest));
        civilityTitleService.save(civilityTitleMapper.addRequestToDto(civilityTitleAddRequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CivilityTitle, ADDED)), HttpStatus.OK);
    }
    /**
     * Handles the incoming POST API "/commercialOperationStatus/update"
     *
     * @param civilityTitleUpdateRequest Action update
     * @return Response
     */
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody @Valid CivilityTitleUpdateRequest civilityTitleUpdateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        civilityTitleService.update(civilityTitleMapper.updateRequestToDto(civilityTitleUpdateRequest));
        return new ResponseEntity<Response>(Response.ok().setPayload(
                getMessageTemplate(CivilityTitle, UPDATED)), HttpStatus.OK);
    }

    /**
     * Handles the incoming DELETE API "/commercialOperationStatus/delete"
     *
     * @param id action delete request
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        civilityTitleService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(CivilityTitle, DELETED)), HttpStatus.OK);
    }

    /**
     * display all commercialOperationStatus GET API "/api/commercialOperationStatus"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allCivilityTitle() {
        return new ResponseEntity<Response>(Response.ok().setPayload(civilityTitleService.getAll()), HttpStatus.OK);
    }
}
