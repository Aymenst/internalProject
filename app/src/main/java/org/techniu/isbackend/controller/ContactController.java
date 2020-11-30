package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.ContactAddRequest;
import org.techniu.isbackend.controller.request.ContactUpdateRequest;
import org.techniu.isbackend.dto.mapper.ContactMapper;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ContactService;

import javax.validation.Valid;

import static org.techniu.isbackend.exception.EntityType.Contact;
import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {
    private final ContactService contactService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ContactMapper contactMapper = Mappers.getMapper(ContactMapper.class);
    public ContactController(ContactService contactService, MapValidationErrorService mapValidationErrorService) {
        this.contactService = contactService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ContactAddRequest contactAddRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // objet address
        Address address =new Address()
                .setFullAddress(contactAddRequest.getFullAddress())
                .setPostCode(contactAddRequest.getPostCode());
        // Save Contact
        contactService.save(contactMapper.addRequestToDto(contactAddRequest),contactAddRequest.getCompanyId(),address,contactAddRequest.getCityId());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Contact, ADDED)), HttpStatus.OK);
    }
    /**
     * Handles the incoming POST API "/contact/update"
     *
     * @param contactUpdateRequest contactUpdateRequest update
     * @return Response
     */
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody @Valid ContactUpdateRequest contactUpdateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // objet address
        Address address =new Address()
                .setFullAddress(contactUpdateRequest.getFullAddress())
                .setPostCode(contactUpdateRequest.getPostCode());
        contactService.update(contactMapper.updateRequestToDto(contactUpdateRequest),contactUpdateRequest.getCompanyId(),address,contactUpdateRequest.getCityId());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Contact, UPDATED)), HttpStatus.OK);
    }

    /**
     * Handles the incoming DELETE API "/contact/delete"
     *
     * @param id contact delete request
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        contactService.remove(id);
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Contact, DELETED)), HttpStatus.OK);
    }

    /**
     * display all contact GET API "/api/contact"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allContact() {
        return new ResponseEntity<Response>(Response.ok().setPayload(contactService.getAll()), HttpStatus.OK);
    }
}
