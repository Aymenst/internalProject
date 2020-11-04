package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.repository.ContractTypeRepository;
import org.techniu.isbackend.repository.LegalCategoryTypeRepository;
import org.techniu.isbackend.repository.StaffContractRepository;
import org.techniu.isbackend.repository.StaffContractHistoryRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StaffContractServiceImpl implements StaffContractService {

    private StaffContractRepository staffContractRepository;
    private ContractTypeRepository contractTypeRepository;
    private LegalCategoryTypeRepository legalCategoryTypeRepository;
    private StaffContractHistoryRepository staffContractHistoryRepository;


    StaffContractServiceImpl(StaffContractRepository staffContractRepository, ContractTypeRepository contractTypeRepository , LegalCategoryTypeRepository legalCategoryTypeRepository, StaffContractHistoryRepository staffContractHistoryRepository ) {
        this.staffContractRepository = staffContractRepository;
        this.contractTypeRepository = contractTypeRepository;
        this.legalCategoryTypeRepository = legalCategoryTypeRepository;
        this.staffContractHistoryRepository = staffContractHistoryRepository;
    }

    @Override
    public StaffContract saveStaffContract(StaffContract staffContract, String contractTypeId, String legalCategoryTypeId) {
        ContractType contractType = contractTypeRepository.findById(contractTypeId).get();
        staffContract.setContractType(contractType);
        LegalCategoryType legalCategoryType = legalCategoryTypeRepository.findById(legalCategoryTypeId).get();
        staffContract.setLegalCategoryType(legalCategoryType);
        staffContract.setCreatedAt(new Date());
        StaffContract staffContract1 = staffContractRepository.save(staffContract);
        StaffContractHistory staffContractHistory = new StaffContractHistory();
        staffContractHistory.setStaffContract(staffContract1);
        staffContractHistory.setStaffContractHistory(staffContract1);
        staffContractHistoryRepository.save(staffContractHistory);
        return staffContract1;
    }

    @Override
    public StaffContract updateStaffContract(String staffContractId, StaffContract staffContract, String contractTypeId, String legalCategoryTypeId) {
        StaffContract staffContract1 = staffContractRepository.findById(staffContractId).get();
        staffContract.setStaffContractId(staffContract1.getStaffContractId());
        if(staffContract.getContractDoc() == null && staffContract1.getContractDoc() != null)  {
            staffContract.setContractDoc(staffContract1.getContractDoc());
            System.out.println(staffContract1.getContractDoc());
        };
        if(staffContract.getInternalRulesDoc() == null  && staffContract1.getInternalRulesDoc() != null)  {
            staffContract.setInternalRulesDoc(staffContract1.getInternalRulesDoc());
            System.out.println(staffContract1.getInternalRulesDoc());
        };
        if(staffContract.getPreContractDoc() == null  && staffContract1.getPreContractDoc() != null)  {
            staffContract.setPreContractDoc(staffContract1.getPreContractDoc());
            System.out.println(staffContract1.getPreContractDoc());
        };
        ContractType contractType = contractTypeRepository.findById(contractTypeId).get();
        staffContract.setContractType(contractType);
        LegalCategoryType legalCategoryType = legalCategoryTypeRepository.findById(legalCategoryTypeId).get();
        staffContract.setLegalCategoryType(legalCategoryType);
        staffContract.setCreatedAt(new Date());
        StaffContractHistory staffContractHistory = new StaffContractHistory();
        staffContractHistory.setStaffContract(staffContract1);
        staffContractHistory.setStaffContractHistory(staffContract);
        staffContractHistoryRepository.save(staffContractHistory);
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
