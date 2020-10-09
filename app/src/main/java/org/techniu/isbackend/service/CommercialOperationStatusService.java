package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;



import java.util.List;

public interface CommercialOperationStatusService {
    /**
     * Register a new CommercialOperationStatus
     *
     * @param commercialOperationStatusDto - commercialOperationStatusDto
     */
    void save(CommercialOperationStatusDto commercialOperationStatusDto);
    /**
     * all ActionsDto
     *
     * @return List commercialOperationStatusDto
     */
    List<CommercialOperationStatusDto> getAll();
    /**
     * Update Action
     *
     * @param commercialOperationStatusDto - commercialOperationStatusDto
     */
    void update(CommercialOperationStatusDto commercialOperationStatusDto);
    /**
     * delete Action
     *
     * @param id - id
     */
    void remove(String id);
}
