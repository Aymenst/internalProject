package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StaffEconomicContractInformationHistoryDto;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;

import java.util.List;

public interface StaffEconomicContractInformationHistoryService {
    void deleteStaffEconomicContractInformationHistory(String staffEconomicContractInformationHistoryId);
    List<StaffEconomicContractInformationHistoryDto> getAllStaffEconomicContractInformationHistory();
    List<StaffEconomicContractInformationHistoryDto> getStaffEconomicContractInformationHistoryByStaffEconomicContractInformation(String staffEconomicContractInformationId);
}
