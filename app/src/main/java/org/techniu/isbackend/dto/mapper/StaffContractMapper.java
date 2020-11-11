package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.StaffContractUpdaterequest;
import org.techniu.isbackend.dto.model.StaffContractDto;
import org.techniu.isbackend.entity.StaffContract;

@Mapper(componentModel = "spring")
public interface StaffContractMapper {
    /**
     * Map dto to model
     *
     * @param staffContractDto staffContractDto
     * @return StaffContract
     */
    @Mapping(source = "staffContractId", target="_id")
    //@Mapping(target = "company", ignore=true)
    //@Mapping(target = "level", ignore=true)
    StaffContract dtoToModel(StaffContractDto staffContractDto);

    /**
     * Map staffContractRequest to staffContractDo
     *
     //* @param staffContractAddrequest staffContractAddrequest
     * @return StaffContractDto
     */
    // @Mapping(target = "cityName", ignore=true)
    // @Mapping(target = "levelId", ignore=true)
    // StaffContractContractDto addRequestToDto(StaffContractContractAddrequest staffContractAddrequest);

        // @Mapping(target = "levelId", ignore=true)
    StaffContractDto updateRequestToDto(StaffContractUpdaterequest staffContractUpdaterequest);

    /**
     * Map staffContract to staffContractDo
     *
     * @param staffContract staffContract
     * @return StaffContractContractDto
     */
    @Mapping(source = "_id", target="staffContractId")
    StaffContractDto modelToDto(StaffContract staffContract);
}
