package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ContractModelAddrequest;
import org.techniu.isbackend.controller.request.ContractModelUpdaterequest;
import org.techniu.isbackend.dto.model.ContractModelDto;
import org.techniu.isbackend.entity.ContractModel;

@Mapper(componentModel = "spring")
public interface ContractModelMapper {
    /**
     * Map dto to model
     *
     * @param contractModelDto contractModelDto
     * @return ContractModel
     */
    @Mapping(source = "contractModelId", target="_id")
    ContractModel dtoToModel(ContractModelDto contractModelDto);

    /**
     * Map ContractModel to ContractModelDo
     *
     * @param contractModelAddrequest contractModelAddrequest
     * @return ContractModelDto
     */
    ContractModelDto addRequestToDto(ContractModelAddrequest contractModelAddrequest);

    /**
     * Map ContractModel to ContractModelDo
     *
     * @param contractModelUpdaterequest contractModelUpdaterequest
     * @return ContractModelDto
     */
    ContractModelDto updateRequestToDto(ContractModelUpdaterequest contractModelUpdaterequest);

    /**
     * Map contractModel to contractModelDo
     *
     * @param contractModel contractModel
     * @return ContractModelDto
     */
    @Mapping(source = "_id", target="contractModelId")
    ContractModelDto modelToDto(ContractModel contractModel);
}
