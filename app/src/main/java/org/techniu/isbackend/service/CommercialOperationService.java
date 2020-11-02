package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.CommercialOperationDto;

import java.util.List;

public interface CommercialOperationService {
    /**
     * Register a new CommercialOperation
     *
     * @param commercialOperationDto - commercialOperationDto
     */
    void save(CommercialOperationDto commercialOperationDto);
    /**
     * all CommercialOperationDto
     *
     * @return List commercialOperationDto
     */
    List<CommercialOperationDto> getAll();
    /**
     * Update Action
     *
     * @param commercialOperationDto - commercialOperationDto
     */
    void update(CommercialOperationDto commercialOperationDto);
    /**
     * delete Action
     *
     * @param id - id
     */
    void remove(String id);
}
