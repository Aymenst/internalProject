package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.FinancialCompanyDto;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.FinancialCompany;

import java.util.List;

public interface FinancialCompanyService {

    void saveFinancialCompany(FinancialCompanyDto ivaDto);

    List<FinancialCompanyDto> getAllFinancialCompany();

    FinancialCompany getById(String id);

    List<FinancialCompanyDto> updateFinancialCompany(FinancialCompanyDto ivaDto, String id);

    List<FinancialCompanyDto> remove(String id);
}
