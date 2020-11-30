package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.AdministrativeStructureLevelAddrequest;
import org.techniu.isbackend.controller.request.AdministrativeStructureLevelUpdaterequest;
import org.techniu.isbackend.dto.model.AdministrativeStructureLevelDto;
import org.techniu.isbackend.entity.AdministrativeStructureLevel;

@Mapper(componentModel = "spring")
public interface AdministrativeStructureLevelMapper {
    /**
     * Map dto to model
     *
     * @param administrativeStructureLevelDto administrativeStructureLevelDto
     * @return AdministrativeStructureLevel
     */
    @Mapping(source = "levelId", target="_id")
    AdministrativeStructureLevel dtoToModel(AdministrativeStructureLevelDto administrativeStructureLevelDto);

    /**
     * Map AdministrativeStructureLevel to AdministrativeStructureLevelDo
     *
     * @param administrativeStructureLevelAddrequest administrativeStructureLevelAddrequest
     * @return AdministrativeStructureLevelDto
     */
    AdministrativeStructureLevelDto addRequestToDto(AdministrativeStructureLevelAddrequest administrativeStructureLevelAddrequest);

    /**
     * Map AdministrativeStructureLevel to AdministrativeStructureLevelDo
     *
     * @param administrativeStructureLevelUpdaterequest administrativeStructureLevelUpdaterequest
     * @return AdministrativeStructureLevelDto
     */
    AdministrativeStructureLevelDto updateRequestToDto(AdministrativeStructureLevelUpdaterequest administrativeStructureLevelUpdaterequest);

    /**
     * Map administrativeStructureLevel to administrativeStructureLevelDo
     *
     * @param administrativeStructureLevel administrativeStructureLevel
     * @return AdministrativeStructureLevelDto
     */
    @Mapping(source = "_id", target="levelId")
    AdministrativeStructureLevelDto modelToDto(AdministrativeStructureLevel administrativeStructureLevel);
}
