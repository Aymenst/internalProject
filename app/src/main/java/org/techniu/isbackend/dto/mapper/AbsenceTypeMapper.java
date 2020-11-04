package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.AbsenceTypeAddrequest;
import org.techniu.isbackend.controller.request.AbsenceTypeUpdaterequest;
import org.techniu.isbackend.dto.model.AbsenceTypeDto;
import org.techniu.isbackend.entity.AbsenceType;

@Mapper(componentModel = "spring")
public interface AbsenceTypeMapper {
    /**
     * Map dto to model
     *
     * @param absenceTypeDto absenceTypeDto
     * @return AbsenceType
     */
    @Mapping(source = "absenceTypeId", target="_id")
    AbsenceType dtoToModel(AbsenceTypeDto absenceTypeDto);

    /**
     * Map AbsenceType to AbsenceTypeDo
     *
     * @param absenceTypeAddrequest absenceTypeAddrequest
     * @return AbsenceTypeDto
     */
    AbsenceTypeDto addRequestToDto(AbsenceTypeAddrequest absenceTypeAddrequest);

    /**
     * Map AbsenceType to AbsenceTypeDo
     *
     * @param absenceTypeUpdaterequest absenceTypeUpdaterequest
     * @return AbsenceTypeDto
     */
    AbsenceTypeDto updateRequestToDto(AbsenceTypeUpdaterequest absenceTypeUpdaterequest);

    /**
     * Map absenceType to absenceTypeDo
     *
     * @param absenceType absenceType
     * @return AbsenceTypeDto
     */
    @Mapping(source = "_id", target="absenceTypeId")
    AbsenceTypeDto modelToDto(AbsenceType absenceType);
}
