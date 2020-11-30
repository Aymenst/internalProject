package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.StaffEconomicContractInformationUpdaterequest;
import org.techniu.isbackend.dto.model.StaffEconomicContractInformationDto;
import org.techniu.isbackend.entity.StaffEconomicContractInformation;

@Mapper(componentModel = "spring")
public interface StaffEconomicContractInformationMapper {
    /**
     * Map dto to model
     *
     * @param staffEconomicContractInformationDto staffEconomicContractInformationDto
     * @return StaffEconomicContractInformation
     */
    @Mapping(source = "staffEconomicContractInformationId", target="_id")
    //@Mapping(target = "company", ignore=true)
    //@Mapping(target = "level", ignore=true)
    StaffEconomicContractInformation dtoToModel(StaffEconomicContractInformationDto staffEconomicContractInformationDto);

    /**
     * Map staffEconomicContractInformationRequest to staffEconomicContractInformationDo
     *
     //* @param staffEconomicContractInformationAddrequest staffEconomicContractInformationAddrequest
     * @return StaffEconomicContractInformationDto
     */
    // @Mapping(target = "cityName", ignore=true)
    // @Mapping(target = "levelId", ignore=true)
    // StaffEconomicContractInformationContractDto addRequestToDto(StaffEconomicContractInformationContractAddrequest staffEconomicContractInformationAddrequest);

        // @Mapping(target = "levelId", ignore=true)
    StaffEconomicContractInformationDto updateRequestToDto(StaffEconomicContractInformationUpdaterequest staffEconomicContractInformationUpdaterequest);

    /**
     * Map staffEconomicContractInformation to staffEconomicContractInformationDo
     *
     * @param staffEconomicContractInformation staffEconomicContractInformation
     * @return StaffEconomicContractInformationContractDto
     */
    @Mapping(source = "_id", target="staffEconomicContractInformationId")
    StaffEconomicContractInformationDto modelToDto(StaffEconomicContractInformation staffEconomicContractInformation);
}
