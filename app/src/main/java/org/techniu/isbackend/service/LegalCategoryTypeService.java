package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.LegalCategoryType;

import java.util.List;

public interface LegalCategoryTypeService {
    LegalCategoryType saveLegalCategoryType(LegalCategoryType legalCategoryType);
    LegalCategoryType updateLegalCategoryType(String legalCategoryTypeId, LegalCategoryType legalCategoryType);
    void deleteLegalCategoryType(String legalCategoryTypeId);
    List<LegalCategoryType> getAllLegalCategoryTypes();
    List<LegalCategoryType> getAllLegalCategoryTypesByCompany(String companyName);
}
