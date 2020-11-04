package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;
import org.techniu.isbackend.repository.StaffEconomicContractInformationHistoryRepository;
import org.techniu.isbackend.repository.StaffEconomicContractInformationRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StaffEconomicContractInformationServiceImpl implements StaffEconomicContractInformationService {

    private StaffEconomicContractInformationRepository staffEconomicContractInformationRepository;
    private StaffEconomicContractInformationHistoryRepository staffEconomicContractInformationHistoryRepository;
    private StaffRepository staffRepository;

    StaffEconomicContractInformationServiceImpl(StaffEconomicContractInformationRepository staffEconomicContractInformationRepository, StaffRepository staffRepository, StaffEconomicContractInformationHistoryRepository staffEconomicContractInformationHistoryRepository) {
        this.staffEconomicContractInformationRepository = staffEconomicContractInformationRepository;
        this.staffRepository = staffRepository;
        this.staffEconomicContractInformationHistoryRepository = staffEconomicContractInformationHistoryRepository;
    }

    @Override
    public StaffEconomicContractInformation saveStaffEconomicContractInformation(StaffEconomicContractInformation staffEconomicContractInformation) {
        staffEconomicContractInformation.setCreatedAt(new Date());
        StaffEconomicContractInformation staffEconomicContractInformation1 = staffEconomicContractInformationRepository.save(staffEconomicContractInformation);
        StaffEconomicContractInformationHistory staffEconomicContractInformationHistory = new StaffEconomicContractInformationHistory();
        staffEconomicContractInformationHistory.setStaffEconomicContractInformationHistory(staffEconomicContractInformation1);
        staffEconomicContractInformationHistory.setStaffEconomicContractInformation(staffEconomicContractInformation1);
        staffEconomicContractInformationHistoryRepository.save(staffEconomicContractInformationHistory);
        return staffEconomicContractInformation1;
    }

    @Override
    public StaffEconomicContractInformation updateStaffEconomicContractInformation(String staffEconomicContractInformationId, StaffEconomicContractInformation staffEconomicContractInformation) {
        StaffEconomicContractInformation staffEconomicContractInformation1 = staffEconomicContractInformationRepository.findById(staffEconomicContractInformationId).get();
        staffEconomicContractInformation.setStaffEconomicContractInformationId(staffEconomicContractInformation1.getStaffEconomicContractInformationId());
        staffEconomicContractInformation.setCreatedAt(new Date());
        StaffEconomicContractInformationHistory staffEconomicContractInformationHistory = new StaffEconomicContractInformationHistory();
        staffEconomicContractInformationHistory.setStaffEconomicContractInformationHistory(staffEconomicContractInformation1);
        staffEconomicContractInformationHistory.setStaffEconomicContractInformation(staffEconomicContractInformation1);
        staffEconomicContractInformationHistoryRepository.save(staffEconomicContractInformationHistory);
        return staffEconomicContractInformationRepository.save(staffEconomicContractInformation);
    }

    @Override
    public void deleteStaffEconomicContractInformation(String staffEconomicContractInformationId) {
        StaffEconomicContractInformation staffEconomicContractInformation = staffEconomicContractInformationRepository.findById(staffEconomicContractInformationId).get();
        staffEconomicContractInformationRepository.delete(staffEconomicContractInformation);
    }


    @Override
    public List<StaffEconomicContractInformation> getAllStaffEconomicContractInformation() {
        return staffEconomicContractInformationRepository.findAll();
    }
}
