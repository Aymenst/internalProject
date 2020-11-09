package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffContract;
import org.techniu.isbackend.entity.StaffContractHistory;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.repository.StaffContractHistoryRepository;
import org.techniu.isbackend.repository.StaffContractRepository;

import java.util.List;

@Service
@Transactional
public class StaffContractHistoryServiceImpl implements StaffContractHistoryService {

    private StaffContractHistoryRepository staffContractHistoryRepository;
    private StaffContractRepository staffContractRepository;

    StaffContractHistoryServiceImpl(StaffContractHistoryRepository staffContractHistoryRepository, StaffContractRepository staffContractRepository) {
        this.staffContractHistoryRepository = staffContractHistoryRepository;
        this.staffContractRepository = staffContractRepository;
    }

    @Override
    public StaffContractHistory saveStaffContractHistory(StaffContractHistory staffContractHistory) {
        return staffContractHistoryRepository.save(staffContractHistory);
    }

    @Override
    public Staff updateStaffContractHistory(String staffContractHistoryId, StaffContractHistory staffContractHistory) {
            return null;
    }

    @Override
    public void deleteStaffContractHistory(String staffContractHistoryId) {
        StaffContractHistory staffContractHistory = staffContractHistoryRepository.findById(staffContractHistoryId).get();
        staffContractHistoryRepository.delete(staffContractHistory);
    }


    @Override
    public List<StaffContractHistory> getAllStaffContractHistory() {
        return staffContractHistoryRepository.findAll();
    }

    @Override
    public List<StaffContractHistory> getStaffContractHistoryByStaff(String id) {
        StaffContract staffContract = staffContractRepository.findById(id).get();
        return staffContractHistoryRepository.findAllByStaffContract(staffContract);
    }
}
