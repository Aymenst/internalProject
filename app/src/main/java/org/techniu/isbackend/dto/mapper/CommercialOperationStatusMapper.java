package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.entity.CommercialOperationStatus;

@Mapper(componentModel = "spring")
public interface CommercialOperationStatusMapper {
    /**
     * Map dto to model
     *
     * @param commercialOperationStatusDto commercialOperationStatusDto
     * @return CommercialOperationStatus
     */
    @Mapping(source = "commercialOperationStatusId", target="_id")
    CommercialOperationStatus dtoToModel(CommercialOperationStatusDto commercialOperationStatusDto);

    /**
     * Map staffRequest to staffDo
     *
     * @param commercialOperationStatusAddrequest commercialOperationStatusAddrequest
     * @return CommercialOperationStatusDto
     */
    CommercialOperationStatusDto addRequestToDto(CommercialOperationStatusAddrequest commercialOperationStatusAddrequest);

    /**
     * Map commercialOperationStatus to commercialOperationStatusDo
     *
     * @param commercialOperationStatus commercialOperationStatus
     * @return CommercialOperationStatusDto
     */
    @Mapping(source = "_id", target="commercialOperationStatusId")
    CommercialOperationStatusDto modelToDto(CommercialOperationStatus commercialOperationStatus);
}
