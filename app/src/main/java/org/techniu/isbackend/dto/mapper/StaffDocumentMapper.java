package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.StaffDocumentAddrequest;
import org.techniu.isbackend.dto.model.StaffDocumentDto;
import org.techniu.isbackend.entity.StaffDocument;

@Mapper(componentModel = "spring")
public interface StaffDocumentMapper {
    /**
     * Map dto to model
     *
     * @param staffDocumentDto staffDocumentDto
     * @return StaffDocument
     */
    @Mapping(source = "staffDocumentId", target="staffDocumentId")
    StaffDocument dtoToModel(StaffDocumentDto staffDocumentDto);

    /**
     * Map staffDocumentRequest to staffDocumentDo
     *
     * @param staffDocumentAddrequest staffDocumentAddrequest
     * @return StaffDocumentDto
     */
    StaffDocumentDto addRequestToDto(StaffDocumentAddrequest staffDocumentAddrequest);

    /**
     * Map staffDocument to staffDocumentDo
     *
     * @param staffDocument staffDocument
     * @return StaffDocumentDto
     */
    @Mapping(source = "staffDocumentId", target="staffDocumentId")
    StaffDocumentDto modelToDto(StaffDocument staffDocument);
}
