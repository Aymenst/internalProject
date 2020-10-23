package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.StaffContract;

import java.util.List;

public interface StaffContractService {
    StaffContract saveStaffContract(StaffContract staffContract);
    StaffContract updateStaffContract(String staffContractId, StaffContract staffContract);
    void deleteStaffContract(String staffContractId);
    List<StaffContract> getAllStaffContracts();
}
