package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.Address;

import java.util.List;

public interface AddressService {
    Address saveAddress(Address address);
    Address updateAddress(String addressId, Address address);
    ResponseEntity<?> deleteAddress(String addressId);
    List<Address> getAllAddress();
    Address getAddressByClient(String clientId);
}
