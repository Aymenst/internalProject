package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.ContractType;
import org.techniu.isbackend.entity.StateCountry;
import org.techniu.isbackend.repository.ContractTypeRepository;
import org.techniu.isbackend.repository.StateCountryRepository;

import java.util.List;

@Service
@Transactional
public class ContractTypeServiceImpl implements ContractTypeService {

    private ContractTypeRepository contractTypeRepository;
    private StateCountryRepository stateCountryRepository;

    ContractTypeServiceImpl(ContractTypeRepository contractTypeRepository, StateCountryRepository stateCountryRepository) {
        this.contractTypeRepository = contractTypeRepository;
        this.stateCountryRepository = stateCountryRepository;
    }

    @Override
    public ContractType saveContractType(ContractType contractType, String stateCountryId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateCountryId).get();
        contractType.setState(stateCountry);
        return contractTypeRepository.save(contractType);
    }

    @Override
    public ContractType updateContractType(String contractTypeId, ContractType contractType) {
        ContractType contractType1 = contractTypeRepository.findById(contractTypeId).get();
        contractType.setContractTypeId(contractType1.getContractTypeId());
        return contractTypeRepository.save(contractType);
    }

    @Override
    public void deleteContractType(String contractTypeId) {
        ContractType contractType = contractTypeRepository.findById(contractTypeId).get();
        contractTypeRepository.delete(contractType);
    }

    @Override
    public List<ContractType> getAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    @Override
    public List<ContractType> getAllByState(String stateCountryId) {
        StateCountry stateCountry = stateCountryRepository.findById(stateCountryId).get();
        return contractTypeRepository.getAllByState(stateCountry);
    }
}
