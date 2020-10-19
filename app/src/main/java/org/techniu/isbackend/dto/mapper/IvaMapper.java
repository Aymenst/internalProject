package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.IvaAddrequest;
import org.techniu.isbackend.controller.request.IvaUpdaterequest;
import org.techniu.isbackend.dto.model.IvaDto;
import org.techniu.isbackend.entity.Iva;

@Mapper(componentModel = "spring")
public interface IvaMapper {
    /**
     * Map dto to model
     *
     * @param ivaDto ivaDto
     * @return Iva
     */
    @Mapping(source = "ivaId", target="_id")
    Iva dtoToModel(IvaDto ivaDto);

    /**
     * Map Iva to IvaDo
     *
     * @param ivaAddrequest ivaAddrequest
     * @return IvaDto
     */
    IvaDto addRequestToDto(IvaAddrequest ivaAddrequest);

    /**
     * Map Iva to IvaDo
     *
     * @param ivaUpdaterequest ivaUpdaterequest
     * @return IvaDto
     */
    IvaDto updateRequestToDto(IvaUpdaterequest ivaUpdaterequest);

    /**
     * Map iva to ivaDo
     *
     * @param iva iva
     * @return IvaDto
     */
    @Mapping(source = "_id", target="ivaId")
    IvaDto modelToDto(Iva iva);
}
