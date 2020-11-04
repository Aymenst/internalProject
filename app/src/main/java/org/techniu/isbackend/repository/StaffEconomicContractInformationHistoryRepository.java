package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;

import java.util.List;

public interface StaffEconomicContractInformationHistoryRepository extends MongoRepository<StaffEconomicContractInformationHistory, String> {

    List<StaffEconomicContractInformationHistory> findAllByStaffEconomicContractInformation(StaffEconomicContractInformation staffEconomicContractInformation);

}
