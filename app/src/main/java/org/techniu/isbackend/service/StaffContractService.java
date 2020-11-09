package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.StaffContract;

import java.util.List;

public interface StaffContractService {
    StaffContract saveStaffContract(StaffContract staffContract, String contractTypeId, String legalCategoryTypeId);
    StaffContract updateStaffContract(String staffContractId, StaffContract staffContract, String contractTypeId, String legalCategoryTypeId);
    void deleteStaffContract(String staffContractId);
    List<StaffContract> getAllStaffContracts();
}
