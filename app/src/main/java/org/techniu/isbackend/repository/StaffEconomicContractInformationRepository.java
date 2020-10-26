package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;

public interface StaffEconomicContractInformationRepository extends MongoRepository<StaffEconomicContractInformation, String> {
}
