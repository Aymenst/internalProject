package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.Client;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, String> {

    Address findAddressByAddressId(String id);

}
