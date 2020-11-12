package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.FinancialContractAddrequest;
import org.techniu.isbackend.controller.request.FinancialContractUpdaterequest;
import org.techniu.isbackend.dto.model.FinancialContractDto;
import org.techniu.isbackend.entity.FinancialContract;

@Mapper(componentModel = "spring")
public interface FinancialContractMapper {
    /**
     * Map dto to model
     *
     * @param financialContractDto financialContractDto
     * @return FinancialContract
     */
    @Mapping(source = "financialContractId", target="_id")
    FinancialContract dtoToModel(FinancialContractDto financialContractDto);

    /**
     * Map FinancialContract to FinancialContractDo
     *
     * @param financialContractAddrequest financialContractAddrequest
     * @return FinancialContractDto
     */
    FinancialContractDto addRequestToDto(FinancialContractAddrequest financialContractAddrequest);

    /**
     * Map FinancialContract to FinancialContractDo
     *
     * @param financialContractUpdaterequest financialContractUpdaterequest
     * @return FinancialContractDto
     */
    FinancialContractDto updateRequestToDto(FinancialContractUpdaterequest financialContractUpdaterequest);

    /**
     * Map financialContract to financialContractDo
     *
     * @param financialContract financialContract
     * @return FinancialContractDto
     */
    @Mapping(source = "_id", target="financialContractId")
    FinancialContractDto modelToDto(FinancialContract financialContract);
}
