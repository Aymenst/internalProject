package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.ContactByOperationDto;

import java.util.List;

public interface ContactByOperationService {
    /**
     * Register a new ContactByOperation
     *
     * @param contactByOperationDto - contactByOperationDto
     */
    void save(ContactByOperationDto contactByOperationDto);
    /**
     * all ContactByOperationDto
     *
     * @return List contactByOperationDto
     */
    List<ContactByOperationDto> getAll();
    /**
     * Update Action
     *
     * @param contactByOperationDto - contactByOperationDto
     */
    void update(ContactByOperationDto contactByOperationDto);
    /**
     * delete Action
     *
     * @param id - id
     */
    void remove(String id);
}
