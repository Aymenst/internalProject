package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.ContractModelDto;

import java.util.List;

public interface ContractModelService {
    void save(ContractModelDto contractModelDto);
    void update(ContractModelDto contractModelDto);
    void remove(String oldId, String newId);
    List<ContractModelDto> getAll();
}
