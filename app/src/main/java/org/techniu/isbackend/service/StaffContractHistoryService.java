package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StaffContractHistoryDto;
import org.techniu.isbackend.entity.StaffContractHistory;

import java.util.List;

public interface StaffContractHistoryService {
    void deleteStaffContractHistory(String staffContractHistoryId);
    List<StaffContractHistoryDto> getAllStaffContractHistory();
    List<StaffContractHistoryDto> getStaffContractHistoryByStaffContract(String staffContractId);
}
