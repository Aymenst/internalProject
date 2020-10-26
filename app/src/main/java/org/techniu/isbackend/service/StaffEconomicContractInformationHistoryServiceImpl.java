package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;
import org.techniu.isbackend.repository.StaffEconomicContractInformationHistoryRepository;
import org.techniu.isbackend.repository.StaffEconomicContractInformationRepository;

import java.util.List;

@Service
@Transactional
public class StaffEconomicContractInformationHistoryServiceImpl implements StaffEconomicContractInformationHistoryService {

    private StaffEconomicContractInformationHistoryRepository staffEconomicContractInformationHistoryRepository;
    private StaffEconomicContractInformationRepository staffEconomicContractInformationRepository;

    StaffEconomicContractInformationHistoryServiceImpl(StaffEconomicContractInformationHistoryRepository staffEconomicContractInformationHistoryRepository, StaffEconomicContractInformationRepository staffEconomicContractInformationRepository) {
        this.staffEconomicContractInformationHistoryRepository = staffEconomicContractInformationHistoryRepository;
        this.staffEconomicContractInformationRepository = staffEconomicContractInformationRepository;
    }

    @Override
    public StaffEconomicContractInformationHistory saveStaffEconomicContractInformationHistory(StaffEconomicContractInformationHistory staffEconomicContractInformationHistory) {
        return staffEconomicContractInformationHistoryRepository.save(staffEconomicContractInformationHistory);
    }

    @Override
    public Staff updateStaffEconomicContractInformationHistory(String staffEconomicContractInformationHistoryId, StaffEconomicContractInformationHistory staffEconomicContractInformationHistory) {
            return null;
    }

    @Override
    public void deleteStaffEconomicContractInformationHistory(String staffEconomicContractInformationHistoryId) {
        StaffEconomicContractInformationHistory staffEconomicContractInformationHistory = staffEconomicContractInformationHistoryRepository.findById(staffEconomicContractInformationHistoryId).get();
        staffEconomicContractInformationHistoryRepository.delete(staffEconomicContractInformationHistory);
    }


    @Override
    public List<StaffEconomicContractInformationHistory> getAllStaffEconomicContractInformationHistory() {
        return staffEconomicContractInformationHistoryRepository.findAll();
    }

    @Override
    public StaffEconomicContractInformationHistory getStaffEconomicContractInformationHistoryByStaff(String id) {
        StaffEconomicContractInformation staffEconomicContractInformation = staffEconomicContractInformationRepository.findById(id).get();
        return staffEconomicContractInformationHistoryRepository.findByStaffEconomicContractInformation(staffEconomicContractInformation);
    }
}
