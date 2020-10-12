package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CommercialOperationStatusAddrequest;
import org.techniu.isbackend.controller.request.CommercialOperationStatusUpdaterequest;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.dto.model.StateCountryDto;
import org.techniu.isbackend.entity.CommercialOperationStatus;
import org.techniu.isbackend.entity.StateCountry;

@Mapper(componentModel = "spring")
public interface StateCountryMapper {

    /**
     * Map dto to model
     *
     * @param commercialOperationStatusDto commercialOperationStatusDto
     * @return CommercialOperationStatus

    @Mapping(source = "stateCountryId", target="_id")
    CommercialOperationStatus dtoToModel(CommercialOperationStatusDto commercialOperationStatusDto);*/

    /**
     * Map CommercialOperationStatus to CommercialOperationStatusDo
     *
     * @param commercialOperationStatusAddrequest commercialOperationStatusAddrequest
     * @return CommercialOperationStatusDto

    CommercialOperationStatusDto addRequestToDto(CommercialOperationStatusAddrequest commercialOperationStatusAddrequest);
     */
    /**
     * Map CommercialOperationStatus to CommercialOperationStatusDo
     *
     * @param commercialOperationStatusUpdaterequest commercialOperationStatusUpdaterequest
     * @return CommercialOperationStatusDto

    CommercialOperationStatusDto updateRequestToDto(CommercialOperationStatusUpdaterequest commercialOperationStatusUpdaterequest);
     */
    /**
     * Map StateCountry to stateCountryDo
     *
     * @param stateCountry stateCountry
     * @return StateCountryDto
     */
    @Mapping(source = "_id", target="stateCountryId")
    StateCountryDto modelToDto(StateCountry stateCountry);
}
