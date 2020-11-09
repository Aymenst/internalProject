package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.ContractTypeDto;
import org.techniu.isbackend.entity.ContractType;

import java.util.List;

public interface ContractTypeService {
    ContractType save(ContractTypeDto contractTypeDto);
    ContractType updateContractType(String contractTypeId, ContractType contractType);
    void remove(String id);
    List<ContractTypeDto> getAllContractTypes();
    List<ContractTypeDto> getAllByState(String stateCountryId);
}
