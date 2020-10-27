package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CommercialOperationAddrequest;
import org.techniu.isbackend.controller.request.CommercialOperationUpdaterequest;
import org.techniu.isbackend.dto.model.CommercialOperationDto;
import org.techniu.isbackend.entity.CommercialOperation;

@Mapper(componentModel = "spring")
public interface CommercialOperationMapper {
    /**
     * Map dto to model
     *
     * @param commercialOperationDto commercialOperationDto
     * @return CommercialOperation
     */
    @Mapping(source = "commercialOperationId", target="_id")
    CommercialOperation dtoToModel(CommercialOperationDto commercialOperationDto);

    /**
     * Map commercialOperationRequest to commercialOperationDo
     *
     * @param commercialOperationAddrequest commercialOperationAddrequest
     * @return CommercialOperationDto
     */
    CommercialOperationDto addRequestToDto(CommercialOperationAddrequest commercialOperationAddrequest);
    /**
     * Map commercialOperationRequest to commercialOperationDo
     *
     * @param commercialOperationUpdaterequest commercialOperationUpdaterequest
     * @return CommercialOperationDto
     */
    CommercialOperationDto updateRequestToDto(CommercialOperationUpdaterequest commercialOperationUpdaterequest);

    /**
     * Map commercialOperation to commercialOperationDo
     *
     * @param commercialOperation commercialOperation
     * @return CommercialOperationDto
     */
    @Mapping(source = "_id", target="commercialOperationId")
    CommercialOperationDto modelToDto(CommercialOperation commercialOperation);
}
