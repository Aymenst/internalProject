package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.CivilityTitleDto;

import java.util.List;

public interface CivilityTitleService {
    /**
     * Register a new CivilityTitleDto
     *
     * @param civilityTitleDto - civilityTitleDto
     */
    void save(CivilityTitleDto civilityTitleDto);
    /**
     * all CivilityTitleDto
     *
     * @return List civilityTitleDto
     */
    List<CivilityTitleDto> getAll();
    /**
     * Update CivilityTitle
     *
     * @param civilityTitleDto - civilityTitleDto
     */
    void update(CivilityTitleDto civilityTitleDto);
    /**
     * delete CivilityTitle
     *
     * @param id - id
     */
    void remove(String id);
}
