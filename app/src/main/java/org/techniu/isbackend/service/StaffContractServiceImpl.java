package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.StaffContract;
import org.techniu.isbackend.repository.StaffContractRepository;

import java.util.List;

@Service
@Transactional
public class StaffContractServiceImpl implements StaffContractService {

    private StaffContractRepository staffContractRepository;

    StaffContractServiceImpl(StaffContractRepository staffContractRepository) {
        this.staffContractRepository = staffContractRepository;
    }

    @Override
    public StaffContract saveStaffContract(StaffContract staffContract) {
        return staffContractRepository.save(staffContract);
    }

    @Override
    public StaffContract updateStaffContract(String staffContractId, StaffContract staffContract) {
        StaffContract staffContract1 = staffContractRepository.findById(staffContractId).get();
        staffContract.setStaffContractId(staffContract1.getStaffContractId());
        return staffContractRepository.save(staffContract);
    }

    @Override
    public void deleteStaffContract(String staffContractId) {
        StaffContract staffContract = staffContractRepository.findById(staffContractId).get();
        staffContractRepository.delete(staffContract);
    }

    @Override
    public List<StaffContract> getAllStaffContracts() {
        return staffContractRepository.findAll();
    }
}
