package org.techniu.isbackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.service.AddressService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AddressController {
    private AddressService addressService;
    AddressController(AddressService addressService){
        this.addressService = addressService;

    }
    @RequestMapping(path = "address",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @RequestMapping(path = "address-update/{addressId}",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Address updateAddress(@RequestBody Address address, @PathVariable(value = "addressId") String  addressId){
        return addressService.updateAddress(addressId, address);
    }


    @RequestMapping(path = "client/address/{clientId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Address getAddressByClient(@PathVariable(value = "clientId") String clientId){
        return addressService.getAddressByClient(clientId);
    }

}
