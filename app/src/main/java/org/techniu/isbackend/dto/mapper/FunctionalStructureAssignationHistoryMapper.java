package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.FunctionalStructureAssignationHistoryAddrequest;
import org.techniu.isbackend.controller.request.FunctionalStructureAssignationHistoryUpdaterequest;
import org.techniu.isbackend.dto.model.FunctionalStructureAssignationHistoryDto;
import org.techniu.isbackend.entity.FunctionalStructureAssignationHistory;

@Mapper(componentModel = "spring")
public interface FunctionalStructureAssignationHistoryMapper {
    /**
     * Map dto to model
     *
     * @param functionalStructureAssignationHistoryDto functionalStructureAssignationHistoryDto
     * @return FunctionalStructureAssignationHistory
     */
    @Mapping(source = "functionalStructureAssignationHistoryId", target="_id")
    FunctionalStructureAssignationHistory dtoToModel(FunctionalStructureAssignationHistoryDto functionalStructureAssignationHistoryDto);

    /**
     * Map functionalStructureAssignationHistoryRequest to functionalStructureAssignationHistoryDo
     *
     * @param functionalStructureAssignationHistoryAddrequest functionalStructureAssignationHistoryAddrequest
     * @return FunctionalStructureAssignationHistoryDto
     */
    FunctionalStructureAssignationHistoryDto addRequestToDto(FunctionalStructureAssignationHistoryAddrequest functionalStructureAssignationHistoryAddrequest);

    FunctionalStructureAssignationHistoryDto updateRequestToDto(FunctionalStructureAssignationHistoryUpdaterequest functionalStructureAssignationHistoryUpdaterequest);

    /**
     * Map functionalStructureAssignationHistory to functionalStructureAssignationHistoryDo
     *
     * @param functionalStructureAssignationHistory functionalStructureAssignationHistory
     * @return FunctionalStructureAssignationHistoryDto
     */
    @Mapping(source = "_id", target="functionalStructureAssignationHistoryId")
    FunctionalStructureAssignationHistoryDto modelToDto(FunctionalStructureAssignationHistory functionalStructureAssignationHistory);
}
