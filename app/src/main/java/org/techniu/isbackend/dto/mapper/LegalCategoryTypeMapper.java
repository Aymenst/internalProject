package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.LegalCategoryTypeAddrequest;
import org.techniu.isbackend.controller.request.LegalCategoryTypeUpdaterequest;
import org.techniu.isbackend.dto.model.LegalCategoryTypeDto;
import org.techniu.isbackend.entity.LegalCategoryType;

@Mapper(componentModel = "spring")
public interface LegalCategoryTypeMapper {
    /**
     * Map dto to model
     *
     * @param legalCategoryTypeDto legalCategoryTypeDto
     * @return LegalCategoryType
     */
    @Mapping(source = "legalCategoryTypeId", target="_id")
    LegalCategoryType dtoToModel(LegalCategoryTypeDto legalCategoryTypeDto);

    /**
     * Map LegalCategoryType to LegalCategoryTypeDo
     *
     * @param legalCategoryTypeAddrequest legalCategoryTypeAddrequest
     * @return LegalCategoryTypeDto
     */
    LegalCategoryTypeDto addRequestToDto(LegalCategoryTypeAddrequest legalCategoryTypeAddrequest);

    /**
     * Map LegalCategoryType to LegalCategoryTypeDo
     *
     * @param legalCategoryTypeUpdaterequest legalCategoryTypeUpdaterequest
     * @return LegalCategoryTypeDto
     */
    LegalCategoryTypeDto updateRequestToDto(LegalCategoryTypeUpdaterequest legalCategoryTypeUpdaterequest);

    /**
     * Map legalCategoryType to legalCategoryTypeDo
     *
     * @param legalCategoryType legalCategoryType
     * @return LegalCategoryTypeDto
     */
    @Mapping(source = "_id", target="legalCategoryTypeId")
    LegalCategoryTypeDto modelToDto(LegalCategoryType legalCategoryType);
}
