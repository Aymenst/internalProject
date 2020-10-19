package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ContractStatusAddrequest;
import org.techniu.isbackend.controller.request.ContractStatusUpdaterequest;
import org.techniu.isbackend.dto.model.ContractStatusDto;
import org.techniu.isbackend.entity.ContractStatus;

@Mapper(componentModel = "spring")
public interface ContractStatusMapper {
    /**
     * Map dto to model
     *
     * @param contractStatusDto contractStatusDto
     * @return ContractStatus
     */
    @Mapping(source = "contractStatusId", target="_id")
    ContractStatus dtoToModel(ContractStatusDto contractStatusDto);

    /**
     * Map ContractStatus to ContractStatusDo
     *
     * @param contractStatusAddrequest contractStatusAddrequest
     * @return ContractStatusDto
     */
    ContractStatusDto addRequestToDto(ContractStatusAddrequest contractStatusAddrequest);

    /**
     * Map ContractStatus to ContractStatusDo
     *
     * @param contractStatusUpdaterequest contractStatusUpdaterequest
     * @return ContractStatusDto
     */
    ContractStatusDto updateRequestToDto(ContractStatusUpdaterequest contractStatusUpdaterequest);

    /**
     * Map contractStatus to contractStatusDo
     *
     * @param contractStatus contractStatus
     * @return ContractStatusDto
     */
    @Mapping(source = "_id", target="contractStatusId")
    ContractStatusDto modelToDto(ContractStatus contractStatus);
}
