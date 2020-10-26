package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.AbsenceType;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface AbsenceTypeRepository extends MongoRepository<AbsenceType, String> {

    List<AbsenceType> getAllByState(StateCountry stateCountry);
}
