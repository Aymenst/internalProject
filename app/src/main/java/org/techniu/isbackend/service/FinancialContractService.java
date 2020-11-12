package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.FinancialContractDto;
import org.techniu.isbackend.entity.FinancialContract;

import java.util.List;

public interface FinancialContractService {

    void saveFinancialContract(FinancialContractDto financialContractDto);

    List<FinancialContractDto> getAllFinancialContract();

    FinancialContract getById(String id);

    List<FinancialContractDto> updateFinancialContract(FinancialContractDto financialContractDto, String id);

    List<FinancialContractDto> remove(String id);
}
