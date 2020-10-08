package org.techniu.isbackend.dto.mapper;


import org.techniu.isbackend.controller.request.StaffAddrequest;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.Staff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StaffMapper{
    /**
     * Map dto to model
     *
     * @param staffDto staffDto
     * @return Staff
     */
    @Mapping(source = "staffId", target="_id")
    @Mapping(target = "address", ignore=true)
    @Mapping(target = "company", ignore=true)
    @Mapping(target = "level", ignore=true)
    @Mapping(target = "identificators", ignore=true)
    Staff dtoToModel(StaffDto staffDto);

    /**
     * Map staffRequest to staffDo
     *
     * @param staffAddrequest staffAddrequest
     * @return StaffDto
     */
    @Mapping(target = "cityName", ignore=true)
    @Mapping(target = "levelId", ignore=true)
    StaffDto addRequestToDto(StaffAddrequest staffAddrequest);

    /**
     * Map staff to staffDo
     *
     * @param staff staff
     * @return StaffDto
     */
    @Mapping(source = "_id", target="staffId")
    StaffDto modelToDto(Staff staff);
}
