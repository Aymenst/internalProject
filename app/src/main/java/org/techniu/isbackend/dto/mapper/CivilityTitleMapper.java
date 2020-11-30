package org.techniu.isbackend.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CivilityTitleAddRequest;
import org.techniu.isbackend.controller.request.CivilityTitleUpdateRequest;
import org.techniu.isbackend.dto.model.CivilityTitleDto;
import org.techniu.isbackend.entity.CivilityTitle;

@Mapper(componentModel = "spring")
public interface CivilityTitleMapper {
    /**
     * Map dto to model
     *
     * @param civilityTitleDto civilityTitleDto
     * @return CivilityTitle
     */
    @Mapping(source = "civilityTitleId", target="_id")
    CivilityTitle dtoToModel(CivilityTitleDto civilityTitleDto);

    /**
     * Map CivilityTitle to CivilityTitleDo
     *
     * @param civilityTitleAddRequest civilityTitleAddRequest
     * @return CivilityTitleDto
     */
    CivilityTitleDto addRequestToDto(CivilityTitleAddRequest civilityTitleAddRequest);

    /**
     * Map CivilityTitle to CivilityTitleDo
     *
     * @param civilityTitleUpdateRequest civilityTitleUpdateRequest
     * @return CivilityTitleDto
     */
    CivilityTitleDto updateRequestToDto(CivilityTitleUpdateRequest civilityTitleUpdateRequest);

    /**
     * Map civilityTitle to civilityTitleDo
     *
     * @param civilityTitle civilityTitle
     * @return CivilityTitleDto
     */
    @Mapping(source = "_id", target="civilityTitleId")
    CivilityTitleDto modelToDto(CivilityTitle civilityTitle);
}
