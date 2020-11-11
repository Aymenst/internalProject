package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.LegalCategoryTypeMapper;
import org.techniu.isbackend.dto.model.LegalCategoryTypeDto;
import org.techniu.isbackend.entity.FinancialCompany;
import org.techniu.isbackend.entity.LegalCategoryType;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.LegalCategoryTypeRepository;
import org.techniu.isbackend.repository.FinancialCompanyRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.*;
import static org.techniu.isbackend.exception.ExceptionType.DUPLICATE_ENTITY;

@Service
@Transactional
public class LegalCategoryTypeServiceImpl implements LegalCategoryTypeService {

    private LegalCategoryTypeRepository legalCategoryTypeRepository;
    private FinancialCompanyRepository financialCompanyRepository;
    private final LegalCategoryTypeMapper legalCategoryTypeMapper = Mappers.getMapper(LegalCategoryTypeMapper.class);

    LegalCategoryTypeServiceImpl(LegalCategoryTypeRepository legalCategoryTypeRepository, FinancialCompanyRepository financialCompanyRepository) {
        this.legalCategoryTypeRepository = legalCategoryTypeRepository;
        this.financialCompanyRepository = financialCompanyRepository;
    }

    @Override
    public void save(LegalCategoryTypeDto legalCategoryTypeDto) {
        FinancialCompany financialCompany = financialCompanyRepository.findById(legalCategoryTypeDto.getFinancialCompanyId()).get();
        LegalCategoryType legalCategoryType = legalCategoryTypeMapper.dtoToModel(legalCategoryTypeDto);
        legalCategoryType.setCompany(financialCompany);


        Optional<LegalCategoryType>  legalCategoryType1= Optional.ofNullable(legalCategoryTypeRepository.findByName(legalCategoryTypeDto.getName()));
        if (legalCategoryType1.isPresent()) {
            throw exception(DUPLICATE_ENTITY);
        }

        legalCategoryTypeRepository.save(legalCategoryType);
    }

    @Override
    public void update(LegalCategoryTypeDto legalCategoryTypeDto) {
        LegalCategoryType legalCategoryType = legalCategoryTypeRepository.findById(legalCategoryTypeDto.getLegalCategoryTypeId()).get();
        legalCategoryType.setName(legalCategoryTypeDto.getName());
        legalCategoryType.setFunctions(legalCategoryTypeDto.getFunctions());

        legalCategoryTypeRepository.save(legalCategoryType);
    }

    @Override
    public void remove(String id) {

        Optional<LegalCategoryType> action = Optional.ofNullable(legalCategoryTypeRepository.findBy_id(id));
        if (!action.isPresent()) {
            throw exception(ENTITY_NOT_FOUND);
        }
        legalCategoryTypeRepository.deleteById(id);
    }

    @Override
    public List<LegalCategoryTypeDto> getAll() {

        List<LegalCategoryType> legalCategoryTypes = legalCategoryTypeRepository.findAll();
        // Create a list of all actions dto
        List<LegalCategoryTypeDto> legalCategoryTypeDtos = new ArrayList<>();

        for (LegalCategoryType legalCategoryType : legalCategoryTypes) {
            LegalCategoryTypeDto legalCategoryTypeDto=legalCategoryTypeMapper.modelToDto(legalCategoryType);
            legalCategoryTypeDto.setFinancialCompanyId(legalCategoryType.getCompany().get_id());
            legalCategoryTypeDto.setCompanyName(legalCategoryType.getCompany().getName());
            legalCategoryTypeDtos.add(legalCategoryTypeDto);
        }
        return legalCategoryTypeDtos;
    }

    @Override
    public List<LegalCategoryTypeDto> getAllByCompany(String companyId) {
        FinancialCompany financialCompany = financialCompanyRepository.findById(companyId).get();

        List<LegalCategoryType> legalCategoryTypes = legalCategoryTypeRepository.getAllByCompany(financialCompany);
        // Create a list of all actions dto
        List<LegalCategoryTypeDto> legalCategoryTypeDtos = new ArrayList<>();

        for (LegalCategoryType legalCategoryType : legalCategoryTypes) {
            LegalCategoryTypeDto legalCategoryTypeDto=legalCategoryTypeMapper.modelToDto(legalCategoryType);
            legalCategoryTypeDto.setFinancialCompanyId(legalCategoryType.getCompany().get_id());
            legalCategoryTypeDto.setCompanyName(legalCategoryType.getCompany().getName());
            legalCategoryTypeDtos.add(legalCategoryTypeDto);
        }
        return legalCategoryTypeDtos;
    }


    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.LegalCategoryType, exceptionType, args);
    }
}
