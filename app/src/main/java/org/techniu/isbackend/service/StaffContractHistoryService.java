package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffContractHistory;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;

import java.util.List;

public interface StaffContractHistoryService {
    StaffContractHistory saveStaffContractHistory(StaffContractHistory staffContractHistory);
    Staff updateStaffContractHistory(String staffContractHistoryId, StaffContractHistory staffContractHistory);
    void deleteStaffContractHistory(String staffContractHistoryId);
    List<StaffContractHistory> getAllStaffContractHistory();
    List<StaffContractHistory> getStaffContractHistoryByStaff(String id);
}
