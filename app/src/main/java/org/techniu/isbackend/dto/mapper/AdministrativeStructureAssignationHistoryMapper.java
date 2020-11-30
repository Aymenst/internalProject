package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.AdministrativeStructureAssignationHistoryAddrequest;
import org.techniu.isbackend.controller.request.AdministrativeStructureAssignationHistoryUpdaterequest;
import org.techniu.isbackend.dto.model.AdministrativeStructureAssignationHistoryDto;
import org.techniu.isbackend.entity.AdministrativeStructureAssignationHistory;

@Mapper(componentModel = "spring")
public interface AdministrativeStructureAssignationHistoryMapper {
    /**
     * Map dto to model
     *
     * @param administrativeStructureAssignationHistoryDto administrativeStructureAssignationHistoryDto
     * @return AdministrativeStructureAssignationHistory
     */
    @Mapping(source = "administrativeStructureAssignationHistoryId", target="_id")
    AdministrativeStructureAssignationHistory dtoToModel(AdministrativeStructureAssignationHistoryDto administrativeStructureAssignationHistoryDto);

    /**
     * Map administrativeStructureAssignationHistoryRequest to administrativeStructureAssignationHistoryDo
     *
     * @param administrativeStructureAssignationHistoryAddrequest administrativeStructureAssignationHistoryAddrequest
     * @return AdministrativeStructureAssignationHistoryDto
     */
    AdministrativeStructureAssignationHistoryDto addRequestToDto(AdministrativeStructureAssignationHistoryAddrequest administrativeStructureAssignationHistoryAddrequest);

    AdministrativeStructureAssignationHistoryDto updateRequestToDto(AdministrativeStructureAssignationHistoryUpdaterequest administrativeStructureAssignationHistoryUpdaterequest);

    /**
     * Map administrativeStructureAssignationHistory to administrativeStructureAssignationHistoryDo
     *
     * @param administrativeStructureAssignationHistory administrativeStructureAssignationHistory
     * @return AdministrativeStructureAssignationHistoryDto
     */
    @Mapping(source = "_id", target="administrativeStructureAssignationHistoryId")
    AdministrativeStructureAssignationHistoryDto modelToDto(AdministrativeStructureAssignationHistory administrativeStructureAssignationHistory);
}
