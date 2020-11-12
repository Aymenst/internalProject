package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.ContactAddRequest;
import org.techniu.isbackend.controller.request.ContactUpdateRequest;
import org.techniu.isbackend.dto.model.ContactDto;
import org.techniu.isbackend.entity.Contact;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    /**
     * Map dto to model
     *
     * @param contactDto contactDto
     * @return Contact
     */
    @Mapping(source = "contactId", target="_id")
    Contact dtoToModel(ContactDto contactDto);

    /**
     * Map Contact to ContactDo
     *
     * @param contactAddRequest contactAddRequest
     * @return ContactDto
     */
    ContactDto addRequestToDto(ContactAddRequest contactAddRequest);

    /**
     * Map Contact to ContactDo
     *
     * @param contactUpdateRequest contactUpdateRequest
     * @return ContactDto
     */
    ContactDto updateRequestToDto(ContactUpdateRequest contactUpdateRequest);

    /**
     * Map contact to contactDo
     *
     * @param contact contact
     * @return ContactDto
     */
    @Mapping(source = "_id", target="contactId")
    ContactDto modelToDto(Contact contact);
}
