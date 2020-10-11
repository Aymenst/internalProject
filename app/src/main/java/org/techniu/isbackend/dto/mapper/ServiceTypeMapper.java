package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ServiceTypeAddrequest;
import org.techniu.isbackend.controller.request.ServiceTypeUpdaterequest;
import org.techniu.isbackend.dto.model.ServiceTypeDto;
import org.techniu.isbackend.entity.ServiceType;

@Mapper(componentModel = "spring")
public interface ServiceTypeMapper {
    /**
     * Map dto to model
     *
     * @param serviceTypeDto serviceTypeDto
     * @return ServiceType
     */
    @Mapping(source = "serviceTypeId", target="_id")
    ServiceType dtoToModel(ServiceTypeDto serviceTypeDto);

    /**
     * Map ServiceType to ServiceTypeDo
     *
     * @param serviceTypeAddrequest serviceTypeAddrequest
     * @return ServiceTypeDto
     */
    ServiceTypeDto addRequestToDto(ServiceTypeAddrequest serviceTypeAddrequest);

    /**
     * Map ServiceType to ServiceTypeDo
     *
     * @param serviceTypeUpdaterequest serviceTypeUpdaterequest
     * @return ServiceTypeDto
     */
    ServiceTypeDto updateRequestToDto(ServiceTypeUpdaterequest serviceTypeUpdaterequest);

    /**
     * Map serviceType to serviceTypeDo
     *
     * @param serviceType serviceType
     * @return ServiceTypeDto
     */
    @Mapping(source = "_id", target="serviceTypeId")
    ServiceTypeDto modelToDto(ServiceType serviceType);
}
