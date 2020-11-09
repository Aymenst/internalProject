package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.AssignmentAddrequest;
import org.techniu.isbackend.controller.request.StaffClientAssignmentAddrequest;
import org.techniu.isbackend.dto.model.AssignmentDto;
import org.techniu.isbackend.dto.model.StaffClientAssignmentDto;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.entity.StaffClientAssignment;

//import org.techniu.isbackend.controller.request.AssignmentUpdaterequest;

@Mapper(componentModel = "spring")
public interface StaffClientAssignmentMapper {
    /**
     * Map dto to model
     *
     * @param staffClientAssignmentDto staffClientAssignmentDto
     * @return staffClientAssignment
     */
    @Mapping(source = "assignmentId", target="_id")
    StaffClientAssignment dtoToModel(StaffClientAssignmentDto staffClientAssignmentDto);

    /**
     * Map Assignment to StaffClientAssignmentDto
     *
     * @param staffClientAssignmentAddrequest staffClientAssignmentAddrequest
     * @return staffClientAssignment
     */
    StaffClientAssignmentDto addRequestToDto(StaffClientAssignmentAddrequest staffClientAssignmentAddrequest);

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
