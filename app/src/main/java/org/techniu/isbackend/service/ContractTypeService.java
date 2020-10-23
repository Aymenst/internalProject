package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.ContractType;

import java.util.List;

public interface ContractTypeService {
    ContractType saveContractType(ContractType contractType, String stateContractId);
    ContractType updateContractType(String contractTypeId, ContractType contractType);
    void deleteContractType(String contractTypeId);
    List<ContractType> getAllContractTypes();
    List<ContractType> getAllByState(String stateCountryId);
}
