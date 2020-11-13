package org.techniu.isbackend.service;
import org.techniu.isbackend.dto.model.ContactDto;
import org.techniu.isbackend.entity.Address;

import java.util.List;

public interface ContactService {
    /**
     * Register a new Contact
     *
     * @param contactDto - contactDto
     */
    void save(ContactDto contactDto, String companyId, Address address, String cityId);
    /**
     * all contactDto
     *
     * @return List contactDto
     */
    List<ContactDto> getAll();
    /**
     * Update Contact
     *
     * @param contactDto - contactDto
     */
    void update(ContactDto contactDto, String companyId, Address address, String cityId);
    /**
     * delete Contact
     *
     * @param id - id
     */
    void remove(String id);
}
