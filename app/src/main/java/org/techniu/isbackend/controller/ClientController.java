package org.techniu.isbackend.controller;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.Response;
import org.techniu.isbackend.controller.request.ClientAddrequest;
import org.techniu.isbackend.dto.mapper.ClientMapper;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.exception.validation.MapValidationErrorService;
import org.techniu.isbackend.service.ClientService;

import javax.validation.Valid;

import static org.techniu.isbackend.exception.EntityType.Client;
import static org.techniu.isbackend.exception.MainException.getMessageTemplate;
import static org.techniu.isbackend.exception.ExceptionType.*;
import java.util.List;

@RestController
@RequestMapping("/api/client")
@CrossOrigin("*")


public class ClientController {
    private ClientService clientService;
    private final MapValidationErrorService mapValidationErrorService;
    private final ClientMapper clientMapper = Mappers.getMapper(ClientMapper.class);
    ClientController(ClientService clientService, MapValidationErrorService mapValidationErrorService){
        this.clientService = clientService;
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid ClientAddrequest clientAddRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return mapValidationErrorService.mapValidationService(bindingResult);
        // Save client
        System.out.println(clientAddRequest);
        Address address = new Address();
        address.setAddress(clientAddRequest.getAddressName());
        address.setPostCode(clientAddRequest.getPostCode());
        clientService.saveClient(clientMapper.dtoToModel(clientMapper.addRequestToDto(clientAddRequest)),address,clientAddRequest.getCityId(),clientAddRequest.getAssistantCommercial(),clientAddRequest.getResponsibleCommercial());
        return new ResponseEntity<Response>(Response.ok().setPayload(getMessageTemplate(Client, ADDED)), HttpStatus.OK);
    }

    /**
     * display all client GET API "/api/client"
     */
    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity allClients() {
        return new ResponseEntity<Response>(Response.ok().setPayload(clientService.getAllClient()), HttpStatus.OK);
    }
/*
    @RequestMapping(path = "clients",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getClients(){
        return clientService.getAllClient();
    }*/

    @RequestMapping(path = "clients-by-country/{country}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getClientsByCountry(@PathVariable(value = "country") String country){
        return clientService.getClientsByCountryName(country);
    }
    @RequestMapping(path = "clients-by-code/{code}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClientByCode(@PathVariable(value = "code") String code){
        return clientService.getClientByCode(code);
    }
}
