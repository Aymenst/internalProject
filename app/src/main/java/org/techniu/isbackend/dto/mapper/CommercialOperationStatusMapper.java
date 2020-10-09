package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.controller.request.CommercialOperationStatusUpdaterequest;
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
     * Map CommercialOperationStatus to CommercialOperationStatusDo
     *
     * @param commercialOperationStatusAddrequest commercialOperationStatusAddrequest
     * @return CommercialOperationStatusDto
     */
    CommercialOperationStatusDto addRequestToDto(CommercialOperationStatusAddrequest commercialOperationStatusAddrequest);

    /**
     * Map CommercialOperationStatus to CommercialOperationStatusDo
     *
     * @param commercialOperationStatusUpdaterequest commercialOperationStatusUpdaterequest
     * @return CommercialOperationStatusDto
     */
    CommercialOperationStatusDto updateRequestToDto(CommercialOperationStatusUpdaterequest commercialOperationStatusUpdaterequest);

    /**
     * Map commercialOperationStatus to commercialOperationStatusDo
     *
     * @param commercialOperationStatus commercialOperationStatus
     * @return CommercialOperationStatusDto
     */
    @Mapping(source = "_id", target="commercialOperationStatusId")
    CommercialOperationStatusDto modelToDto(CommercialOperationStatus commercialOperationStatus);
}
