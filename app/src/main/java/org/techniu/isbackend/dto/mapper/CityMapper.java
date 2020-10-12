package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.dto.model.CityDto;
import org.techniu.isbackend.dto.model.StateCountryDto;
import org.techniu.isbackend.entity.City;
import org.techniu.isbackend.entity.StateCountry;

@Mapper(componentModel = "spring")
public interface CityMapper {

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
     * Map City to CityDo
     *
     * @param city city
     * @return CityDto
     */
    @Mapping(source = "_id", target="cityId")
    CityDto modelToDto(City city);
}
