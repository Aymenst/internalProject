package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.StaffContract;
import org.techniu.isbackend.entity.StaffContractHistory;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;

import java.util.List;

public interface StaffContractHistoryRepository extends MongoRepository<StaffContractHistory, String> {

    List<StaffContractHistory> findAllByStaffContract(StaffContract staffContract);

}
