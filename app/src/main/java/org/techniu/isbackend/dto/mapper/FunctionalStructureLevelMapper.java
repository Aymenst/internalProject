package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.FunctionalStructureLevelAddrequest;
import org.techniu.isbackend.controller.request.FunctionalStructureLevelUpdaterequest;
import org.techniu.isbackend.dto.model.FunctionalStructureLevelDto;
import org.techniu.isbackend.entity.FunctionalStructureLevel;

@Mapper(componentModel = "spring")
public interface FunctionalStructureLevelMapper {
    /**
     * Map dto to model
     *
     * @param functionalStructureLevelDto functionalStructureLevelDto
     * @return FunctionalStructureLevel
     */
    @Mapping(source = "levelId", target="_id")
    FunctionalStructureLevel dtoToModel(FunctionalStructureLevelDto functionalStructureLevelDto);

    /**
     * Map FunctionalStructureLevel to FunctionalStructureLevelDo
     *
     * @param functionalStructureLevelAddrequest functionalStructureLevelAddrequest
     * @return FunctionalStructureLevelDto
     */
    FunctionalStructureLevelDto addRequestToDto(FunctionalStructureLevelAddrequest functionalStructureLevelAddrequest);

    /**
     * Map FunctionalStructureLevel to FunctionalStructureLevelDo
     *
     * @param functionalStructureLevelUpdaterequest functionalStructureLevelUpdaterequest
     * @return FunctionalStructureLevelDto
     */
    FunctionalStructureLevelDto updateRequestToDto(FunctionalStructureLevelUpdaterequest functionalStructureLevelUpdaterequest);

    /**
     * Map functionalStructureLevel to functionalStructureLevelDo
     *
     * @param functionalStructureLevel functionalStructureLevel
     * @return FunctionalStructureLevelDto
     */
    @Mapping(source = "_id", target="levelId")
    FunctionalStructureLevelDto modelToDto(FunctionalStructureLevel functionalStructureLevel);
}
