package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.LegalCategoryTypeDto;
import org.techniu.isbackend.entity.LegalCategoryType;

import java.util.List;

public interface LegalCategoryTypeService {
    void save(LegalCategoryTypeDto legalCategoryTypeDto);
    void update(LegalCategoryTypeDto legalCategoryTypeDto);
    void remove(String id);
    List<LegalCategoryTypeDto> getAllLegalCategoryTypes();
    List<LegalCategoryTypeDto> getAllByCompany(String companyId);
}
