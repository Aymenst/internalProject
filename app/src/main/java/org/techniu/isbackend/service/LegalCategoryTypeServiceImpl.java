package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.LegalCategoryType;
import org.techniu.isbackend.repository.LegalCategoryTypeRepository;

import java.util.List;

@Service
@Transactional
public class LegalCategoryTypeServiceImpl implements LegalCategoryTypeService {

    private LegalCategoryTypeRepository legalCategoryTypeRepository;

    LegalCategoryTypeServiceImpl(LegalCategoryTypeRepository legalCategoryTypeRepository) {
        this.legalCategoryTypeRepository = legalCategoryTypeRepository;
    }

    @Override
    public LegalCategoryType saveLegalCategoryType(LegalCategoryType legalCategoryType) {
        return legalCategoryTypeRepository.save(legalCategoryType);
    }

    @Override
    public LegalCategoryType updateLegalCategoryType(String legalCategoryTypeId, LegalCategoryType legalCategoryType) {
        LegalCategoryType legalCategoryType1 = legalCategoryTypeRepository.findById(legalCategoryTypeId).get();
        legalCategoryType.setLegalCategoryTypeId(legalCategoryType1.getLegalCategoryTypeId());
        return legalCategoryTypeRepository.save(legalCategoryType);
    }

    @Override
    public void deleteLegalCategoryType(String legalCategoryTypeId) {
        LegalCategoryType legalCategoryType = legalCategoryTypeRepository.findById(legalCategoryTypeId).get();
        legalCategoryTypeRepository.delete(legalCategoryType);
    }

    @Override
    public List<LegalCategoryType> getAllLegalCategoryTypes() {
        return legalCategoryTypeRepository.findAll();
    }

    @Override
    public List<LegalCategoryType> getAllLegalCategoryTypesByCompany(String companyName) {
        return legalCategoryTypeRepository.getAllByCompanyName(companyName);
    }
}
