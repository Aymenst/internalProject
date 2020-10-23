package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.FinancialCompanyAddrequest;
import org.techniu.isbackend.controller.request.FinancialCompanyUpdaterequest;
import org.techniu.isbackend.dto.model.FinancialCompanyDto;
import org.techniu.isbackend.entity.FinancialCompany;

@Mapper(componentModel = "spring")
public interface FinancialCompanyMapper {
    /**
     * Map dto to model
     *
     * @param financialCompanyDto financialCompanyDto
     * @return FinancialCompany
     */
    @Mapping(source = "financialCompanyId", target="_id")
    FinancialCompany dtoToModel(FinancialCompanyDto financialCompanyDto);

    /**
     * Map FinancialCompany to FinancialCompanyDo
     *
     * @param financialCompanyAddrequest financialCompanyAddrequest
     * @return FinancialCompanyDto
     */
    FinancialCompanyDto addRequestToDto(FinancialCompanyAddrequest financialCompanyAddrequest);

    /**
     * Map FinancialCompany to FinancialCompanyDo
     *
     * @param financialCompanyUpdaterequest financialCompanyUpdaterequest
     * @return FinancialCompanyDto
     */
    FinancialCompanyDto updateRequestToDto(FinancialCompanyUpdaterequest financialCompanyUpdaterequest);

    /**
     * Map financialCompany to financialCompanyDo
     *
     * @param financialCompany financialCompany
     * @return FinancialCompanyDto
     */
    @Mapping(source = "_id", target="financialCompanyId")
    FinancialCompanyDto modelToDto(FinancialCompany financialCompany);
}
