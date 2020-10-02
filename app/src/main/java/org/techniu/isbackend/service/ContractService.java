package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.Contract;
import org.techniu.isbackend.entity.FunctionalStructureLevel;

import java.util.List;

public interface ContractService {
    Contract saveContract(Contract contract);
    ResponseEntity<?> deleteContract(String contractId);
    List<Contract> getAllContracts();
}
