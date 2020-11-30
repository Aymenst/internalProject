package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StaffContractDto;
import org.techniu.isbackend.entity.StaffContract;

import java.util.List;

public interface StaffContractService {
    void update(StaffContractDto staffContractDto);

    List<StaffContract> getAllByContractType(String contractTypeId);

    List<StaffContract> getAllByLegalCategoryType(String legalCategoryTypeId);

    List<StaffContract> getAllByContractModel(String contractModelId);

}
