package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ContactByOperationAddRequest;
import org.techniu.isbackend.controller.request.ContactByOperationUpdateRequest;
import org.techniu.isbackend.dto.model.ContactByOperationDto;
import org.techniu.isbackend.entity.ContactByOperation;

@Mapper(componentModel = "spring")
public interface ContactByOperationMapper {
    /**
     * Map dto to model
     *
     * @param contactByOperationDto contactByOperationDto
     * @return ContactByOperation
     */
    @Mapping(source = "contactByOperationId", target="_id")
    ContactByOperation dtoToModel(ContactByOperationDto contactByOperationDto);

    /**
     * Map ContactByOperation to ContactByOperationDo
     *
     * @param contactByOperationAddRequest contactByOperationAddRequest
     * @return ContactByOperationDto
     */
    ContactByOperationDto addRequestToDto(ContactByOperationAddRequest contactByOperationAddRequest);

    /**
     * Map ContactByOperation to ContactByOperationDo
     *
     * @param contactByOperationUpdateRequest contactByOperationUpdateRequest
     * @return ContactByOperationDto
     */
    ContactByOperationDto updateRequestToDto(ContactByOperationUpdateRequest contactByOperationUpdateRequest);

    /**
     * Map contactByOperation to contactByOperationDo
     *
     * @param contactByOperation contactByOperation
     * @return ContactByOperationDto
     */
    @Mapping(source = "_id", target="contactByOperationId")
    ContactByOperationDto modelToDto(ContactByOperation contactByOperation);
}
