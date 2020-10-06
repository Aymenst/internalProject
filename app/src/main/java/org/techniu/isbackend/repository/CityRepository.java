package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.*;

import java.util.List;

public interface CityRepository extends MongoRepository<City, String> {
   // List<Assignment> findByClient(Client client);
   // List<Assignment> findByStaff(Staff staff);
    City findCityBy_id(String id);
    City findCityByCityName(String cityName);
    List<City> findAllByStateCountry(StateCountry stateCountry);
}
