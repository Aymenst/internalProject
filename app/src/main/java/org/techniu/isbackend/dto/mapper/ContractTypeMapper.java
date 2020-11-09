package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ContractTypeAddrequest;
import org.techniu.isbackend.controller.request.ContractTypeUpdaterequest;
import org.techniu.isbackend.dto.model.ContractTypeDto;
import org.techniu.isbackend.entity.ContractType;

@Mapper(componentModel = "spring")
public interface ContractTypeMapper {
    /**
     * Map dto to model
     *
     * @param contractTypeDto contractTypeDto
     * @return ContractType
     */
    @Mapping(source = "contractTypeId", target="_id")
    ContractType dtoToModel(ContractTypeDto contractTypeDto);

    /**
     * Map ContractType to ContractTypeDo
     *
     * @param contractTypeAddrequest contractTypeAddrequest
     * @return ContractTypeDto
     */
    ContractTypeDto addRequestToDto(ContractTypeAddrequest contractTypeAddrequest);

    /**
     * Map ContractType to ContractTypeDo
     *
     * @param contractTypeUpdaterequest contractTypeUpdaterequest
     * @return ContractTypeDto
     */
    ContractTypeDto updateRequestToDto(ContractTypeUpdaterequest contractTypeUpdaterequest);

    /**
     * Map contractType to contractTypeDo
     *
     * @param contractType contractType
     * @return ContractTypeDto
     */
    @Mapping(source = "_id", target="contractTypeId")
    ContractTypeDto modelToDto(ContractType contractType);
}
