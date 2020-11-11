package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.model.StaffContractDto;
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
    public void update(StaffContractDto staffContractDto) {

        StaffContract staffContract = new StaffContract();
        staffContract.setAssociateOffice(staffContractDto.getAssociateOffice());
        staffContract.setHiringCountry(staffContractDto.getHiringCountry());
        staffContract.setTownContract(staffContractDto.getTownContract());
        staffContract.setPersonalNumber(staffContractDto.getPersonalNumber());
        staffContract.setHighDate(staffContractDto.getHighDate());
        staffContract.setLowDate(staffContractDto.getLowDate());
        staffContract.setRegistrationDate(staffContractDto.getRegistrationDate());
        staffContract.setPreContractDate(staffContractDto.getPreContractDate());

        StaffContract staffContract1 = staffContractRepository.findById(staffContractDto.getStaffContractId()).get();
        if(staffContractDto.getContractDoc() == null && staffContract1.getContractDoc() != null)  {
            staffContract.setContractDoc(staffContract1.getContractDoc());
        } else staffContract.setContractDoc(staffContractDto.getContractDoc());
        if(staffContractDto.getInternalRulesDoc() == null  && staffContract1.getInternalRulesDoc() != null)  {
            staffContract.setInternalRulesDoc(staffContract1.getInternalRulesDoc());
        } else staffContract.setInternalRulesDoc(staffContractDto.getInternalRulesDoc());
        if(staffContractDto.getPreContractDoc() == null  && staffContract1.getPreContractDoc() != null)  {
            staffContract.setPreContractDoc(staffContract1.getPreContractDoc());
        } else staffContract.setPreContractDoc(staffContractDto.getPreContractDoc());
        ContractType contractType = contractTypeRepository.findById(staffContractDto.getContractTypeId()).get();
        staffContract.setContractType(contractType);
        LegalCategoryType legalCategoryType = legalCategoryTypeRepository.findById(staffContractDto.getLegalCategoryTypeId()).get();
        staffContract.setLegalCategoryType(legalCategoryType);
        StaffContractHistory staffContractHistory = new StaffContractHistory();
        staffContractHistory.setStaffContract(staffContract1);
        staffContractHistory.setStaffContractHistory(staffContract);
        staffContractHistory.setUpdatedAt(staffContractDto.getUpdatedAt());
        staffContractHistoryRepository.save(staffContractHistory);
        staffContractRepository.save(staffContract);
    }
}
