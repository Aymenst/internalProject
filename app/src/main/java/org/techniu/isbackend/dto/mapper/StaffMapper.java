package org.techniu.isbackend.dto.mapper;


import org.techniu.isbackend.controller.request.StaffAddrequest;
import org.techniu.isbackend.controller.request.StaffUpdaterequest;
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
    @Mapping(source = "staffId", target="staffId")
    @Mapping(target = "address", ignore=true)
    //@Mapping(target = "company", ignore=true)
    //@Mapping(target = "level", ignore=true)
    Staff dtoToModel(StaffDto staffDto);

    /**
     * Map staffRequest to staffDo
     *
     * @param staffAddrequest staffAddrequest
     * @return StaffDto
     */
    @Mapping(target = "cityName", ignore=true)
    // @Mapping(target = "levelId", ignore=true)
    StaffDto addRequestToDto(StaffAddrequest staffAddrequest);

    @Mapping(target = "cityName", ignore=true)
        // @Mapping(target = "levelId", ignore=true)
    StaffDto updateRequestToDto(StaffUpdaterequest staffUpdaterequest);

    /**
     * Map staff to staffDo
     *
     * @param staff staff
     * @return StaffDto
     */
    @Mapping(source = "staffId", target="staffId")
    StaffDto modelToDto(Staff staff);
}
