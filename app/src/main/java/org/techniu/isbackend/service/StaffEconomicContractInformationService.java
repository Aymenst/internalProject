package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.StaffEconomicContractInformation;

import java.util.List;

public interface StaffEconomicContractInformationService {
    StaffEconomicContractInformation saveStaffEconomicContractInformation(StaffEconomicContractInformation staffEconomicContractInformation);
    StaffEconomicContractInformation updateStaffEconomicContractInformation(String staffEconomicContractInformationId, StaffEconomicContractInformation staffEconomicContractInformation);
    void deleteStaffEconomicContractInformation(String staffEconomicContractInformationId);
    List<StaffEconomicContractInformation> getAllStaffEconomicContractInformation();
}
