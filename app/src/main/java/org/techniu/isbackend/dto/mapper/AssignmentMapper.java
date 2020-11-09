package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.AssignmentAddrequest;
//import org.techniu.isbackend.controller.request.AssignmentUpdaterequest;
import org.techniu.isbackend.dto.model.AssignmentDto;
import org.techniu.isbackend.entity.Assignment;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    /**
     * Map dto to model
     *
     * @param assignmentDto assignmentDto
     * @return Assignment
     */
    @Mapping(source = "assignmentId", target="_id")
    Assignment dtoToModel(AssignmentDto assignmentDto);

    /**
     * Map Assignment to AssignmentDo
     *
     * @param assignmentAddrequest assignmentAddrequest
     * @return AssignmentDto
     */
    AssignmentDto addRequestToDto(AssignmentAddrequest assignmentAddrequest);

    /**
     * Map Assignment to AssignmentDo
     *
     * @param assignmentUpdaterequest assignmentUpdaterequest
     * @return AssignmentDto

    AssignmentDto updateRequestToDto(AssignmentUpdaterequest assignmentUpdaterequest);
     */

    /**
     * Map assignment to assignmentDo
     *
     * @param assignment assignment
     * @return AssignmentDto
     */
    @Mapping(source = "_id", target="assignmentId")
    AssignmentDto modelToDto(Assignment assignment);
}
