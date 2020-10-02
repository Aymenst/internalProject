package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.repository.AddressRepository;
import org.techniu.isbackend.repository.ClientRepository;

import java.util.List;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private ClientRepository clientRepository;

    AddressServiceImpl(AddressRepository addressRepository, ClientRepository clientRepository) {
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;

    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);

    }

    @Override
    public Address updateAddress(String addressId, Address address) {
        return addressRepository.findById(addressId).map(address1 -> {
            address.setAddressId(address1.getAddressId());
            return addressRepository.save(address);
        }).orElseThrow(() -> new ExceptionMessage("Cannot update address"));
    }

    @Override
    public ResponseEntity<?> deleteAddress(String addressId) {
        return addressRepository.findById(addressId).map(address -> {
            addressRepository.delete(address);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ExceptionMessage("Cannot delete address"));
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressByClient(String clientId) {
        System.out.println(clientId);
        /*
        return clientRepository.findById(clientId).map(client -> addressRepository.getByClient(client)).orElseThrow(() -> new ExceptionMessage("Cannot get address by Client"));
    */
        return null;
    }

}
