package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.service.ClientService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClientController {
    private ClientService clientService;
    ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @RequestMapping(path = "client",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client) ;
    }

    @RequestMapping(path = "clients",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getClients(){
        return clientService.getAllClient();
    }

    @RequestMapping(path = "clients-by-country/{country}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getClientsByCountry(@PathVariable(value = "country") String country){
        return clientService.getClientsByCountryName(country);
    }
    @RequestMapping(path = "clients-by-code/{code}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClientByCode(@PathVariable(value = "code") String code){
        return clientService.getClientByCode(code);
    }
}
