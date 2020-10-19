package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.dto.model.ContractStatusDto;
import org.techniu.isbackend.entity.ContractStatus;

import java.util.List;

public interface ContractStatusService {
    void saveContractStatus(ContractStatusDto contractStatusdto);
    // ContractStatus updateContractStatus(ContractStatus contractStatus);
    // ResponseEntity<?> deleteContractStatus(String contractStatusId);
    List<ContractStatus> getAllContractStatus();

    List<ContractStatusDto> getAllContractStatus2();

    ContractStatus getById(String id);

    List<ContractStatusDto> updateContractStatus(ContractStatusDto contractStatusDto, String id);

    List<ContractStatusDto> remove(String id);
}
