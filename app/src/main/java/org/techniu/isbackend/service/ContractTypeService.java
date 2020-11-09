package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.ContractTypeDto;
import org.techniu.isbackend.entity.ContractType;

import java.util.List;

public interface ContractTypeService {
    void save(ContractTypeDto contractTypeDto);
    void update(ContractTypeDto contractTypeDto);
    void remove(String id);
    List<ContractTypeDto> getAllContractTypes();
    List<ContractTypeDto> getAllByState(String stateCountryId);
}
