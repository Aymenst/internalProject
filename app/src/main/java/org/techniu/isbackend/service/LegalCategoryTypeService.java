package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.LegalCategoryTypeDto;
import org.techniu.isbackend.entity.LegalCategoryType;

import java.util.List;

public interface LegalCategoryTypeService {
    void save(LegalCategoryTypeDto legalCategoryTypeDto);
    void update(LegalCategoryTypeDto legalCategoryTypeDto);
    void remove(String oldId, String newId);
    List<LegalCategoryTypeDto> getAll();
    List<LegalCategoryTypeDto> getAllByCompany(String companyId);
}
