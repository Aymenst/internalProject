package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.ServiceTypeDto;

import java.util.List;

public interface ServiceTypeService {
    /**
     * Register a new serviceType
     *
     * @param serviceTypeDto - serviceTypeDto
     */
    void save(ServiceTypeDto serviceTypeDto);
    /**
     * all ServiceTypeDto
     *
     * @return List serviceTypeDto
     */
    List<ServiceTypeDto> getAll();
    /**
     * Update Action
     *
     * @param serviceTypeDto - serviceTypeDto
     */
    void update(ServiceTypeDto serviceTypeDto);
    /**
     * delete Action
     *
     * @param id - id
     */
    void remove(String id);

    void removeUpdate(List<String> serviceType, List<String> listOperation);
}
