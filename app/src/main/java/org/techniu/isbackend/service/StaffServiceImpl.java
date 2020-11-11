package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.FunctionalStructureLevelMapper;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.dto.model.FunctionalStructureLevelDto;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;
    private FunctionalStructureLevelRepository functionalStructureLevelRepository;
    private AddressRepository addressRepository;
    private StaffDocumentsRepository staffDocumentsRepository;
    private StaffContractRepository staffContractRepository;
    private CityRepository cityRepository;
    private ContractTypeRepository contractTypeRepository;
    private LegalCategoryTypeRepository legalCategoryTypeRepository;
    private FinancialCompanyRepository financialCompanyRepository;
    private StaffEconomicContractInformationService staffEconomicContractInformationService;

    private final FunctionalStructureLevelMapper functionalStructureLevelMapper = Mappers.getMapper(FunctionalStructureLevelMapper.class);
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);

    StaffServiceImpl(
            StaffRepository staffRepository,
            FunctionalStructureLevelRepository functionalStructureLevelRepository,
            StaffDocumentsRepository staffDocumentsRepository,
            StaffContractRepository staffContractRepository,
            ContractTypeRepository contractTypeRepository,
            LegalCategoryTypeRepository legalCategoryTypeRepository,
            FinancialCompanyRepository financialCompanyRepository,
            AddressRepository addressRepository, CityRepository cityRepository, StaffEconomicContractInformationService staffEconomicContractInformationService) {
        this.staffRepository = staffRepository;
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffDocumentsRepository = staffDocumentsRepository;
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.staffEconomicContractInformationService = staffEconomicContractInformationService;
        this.staffContractRepository = staffContractRepository;
        this.contractTypeRepository = contractTypeRepository;
        this.legalCategoryTypeRepository = legalCategoryTypeRepository;
        this.financialCompanyRepository = financialCompanyRepository;
    }

    @Override
    public Staff saveStaff(Staff staff, City city, StaffEconomicContractInformation staffEconomicContractInformation, StaffContract staffContract, List<StaffDocuments> staffDocumentsList) {
        Address address = staff.getAddress();
        System.out.println(address);
        address.setCity(city);
        System.out.println(city);
        Address address1 = addressRepository.save(address);
        staff.setAddress(address1);
        staff.setStaffContract(staffContract);
        staff.setAddress(null);
        StaffEconomicContractInformation staffEconomicContractInformation2 = staffEconomicContractInformationService.saveStaffEconomicContractInformation(staffEconomicContractInformation);
        staff.setStaffEconomicContractInformation(staffEconomicContractInformation2);
        staff.setStaffDocuments(staffDocumentsRepository.saveAll(staffDocumentsList));
        return staffRepository.save(staff);
    }
    @Override
    public Staff save(StaffDto staffDto, String cityId, Address address, StaffEconomicContractInformation staffEconomicContractInformation, StaffContract staffContract, String companyId, String contractTypeId, String legalCategoryTypeId,  List<StaffDocuments> staffDocumentsList) {
        address.setCity( cityRepository.findCityBy_id(cityId));
        Staff staff = staffMapper.dtoToModel(staffDto);
        System.out.println(companyId);
        System.out.println(financialCompanyRepository.findById(companyId));
        staffContract.setCompany(financialCompanyRepository.findById(companyId).get());
        staffContract.setContractType(contractTypeRepository.findById(contractTypeId).get());
        staffContract.setLegalCategoryType(legalCategoryTypeRepository.findById(legalCategoryTypeId).get());
        staff.setAddress(addressRepository.save(address));
        staff.setStaffContract(staffContractRepository.save(staffContract));
        staff.setStaffEconomicContractInformation(staffEconomicContractInformationService.saveStaffEconomicContractInformation(staffEconomicContractInformation));
        staff.setStaffDocuments(staffDocumentsRepository.saveAll(staffDocumentsList));
        return staffRepository.save(staff);
    }

    @Override
    public Staff update(StaffDto staffDto, String cityId, Address address) {
        address.setCity( cityRepository.findCityBy_id(cityId));
        Address address1 = addressRepository.save(address);
        Staff staff = staffMapper.dtoToModel(staffDto);
        staff.setAddress(address1);
        return staffRepository.save(staff);
    }

    @Override
    public Staff updateStaff(String staffId, String cityId, Staff staff) {
        return null;
    }

    @Override
    public String deleteStaff(String staffId) {
        Optional<Staff> staff = staffRepository.findById(staffId);
        if (staff.isPresent()) {
            staffRepository.delete(staff.get());
            return "done";
        } else return "invalide to delete";

    }

    @Override
    public List<Staff> getAllStaffs() {
        return staffRepository.findAll();
    }

    @Override
    public StaffDto getStaffById(String staffId) {
        Staff staff = staffRepository.findById(staffId).get();
        return staffToStaffDto(staff);
    }

    @Override
    public List<StaffDto> getAll() {
        // Get all actions
        List<Staff> staffs = staffRepository.findAll();
        // Create a list of all staff dto
        ArrayList<StaffDto> staffDtos = new ArrayList<>();

        for (Staff staff : staffs) {

            staffDtos.add(staffToStaffDto(staff));
        }
        return staffDtos;
    }

    @Override
    public List<Staff> getAllNotAssignedStaffs() {
        return staffRepository.findAllByLevelIsNull();
    }

    @Override
    public void assignLevelToStaff(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        FunctionalStructureLevelDto functionalStructureLevelDto = mapper.convertValue(objects.get(0), FunctionalStructureLevelDto.class);
        FunctionalStructureLevel functionalStructureLevel = functionalStructureLevelRepository.findById(functionalStructureLevelDto.getLevelId()).get();
        List<Staff> assignedStaffs = mapper.convertValue(objects.get(1), new TypeReference<List<Staff>>() { });
        List<Staff> notAssignedStaffs = mapper.convertValue(objects.get(2), new TypeReference<List<Staff>>() { });
        notAssignedStaffs.forEach(staff -> {
            staff.setLevel(null);
            staffRepository.save(staff);
        });
        assignedStaffs.forEach(staff -> {
            staff.setLevel(functionalStructureLevel);
            staffRepository.save(staff);
        });
    }

    @Override
    public List<Staff> getStaffsByLevel(String levelId, String isLeader) {
        FunctionalStructureLevel level = functionalStructureLevelRepository.findById(levelId).get();
        List<Staff> staffs = staffRepository.findAllByLevelAndIsLeader(level, isLeader);
        return staffs;
    }

    public StaffDto staffToStaffDto(Staff staff) {
        StaffDto staffDto=staffMapper.modelToDto(staff);
        // Address
        staffDto.setAddressId(staff.getAddress().getAddressId());
        staffDto.setCityId(staff.getAddress().getCity().get_id());
        staffDto.setFullAddress(staff.getAddress().getFullAddress());
        staffDto.setCityName(staff.getAddress().getCity().getCityName());
        staffDto.setStateName(staff.getAddress().getCity().getStateCountry().getStateName());
        staffDto.setCountryName(staff.getAddress().getCity().getStateCountry().getCountry().getCountryName());
        staffDto.setPostCode(staff.getAddress().getPostCode());
        // Documentation
        staffDto.setStaffDocuments(staff.getStaffDocuments());
        // Contract
        staffDto.setStaffContractId(staff.getStaffContract().getStaffContractId());
        staffDto.setCompanyId(staff.getStaffContract().getCompany().get_id());
        staffDto.setCompanyName(staff.getStaffContract().getCompany().getName());
        staffDto.setAssociateOffice(staff.getStaffContract().getAssociateOffice());
        staffDto.setHiringCountry(staff.getStaffContract().getHiringCountry());
        staffDto.setTownContract(staff.getStaffContract().getTownContract());
        staffDto.setPersonalNumber(staff.getStaffContract().getPersonalNumber());
        staffDto.setHighDate(staff.getStaffContract().getHighDate());
        staffDto.setLowDate(staff.getStaffContract().getLowDate());
        staffDto.setRegistrationDate(staff.getStaffContract().getRegistrationDate());
        staffDto.setPreContractDate(staff.getStaffContract().getPreContractDate());
        staffDto.setContractTypeId(staff.getStaffContract().getContractType().get_id());
        staffDto.setContractTypeName(staff.getStaffContract().getContractType().getName());
        staffDto.setContractTypeCountryId(staff.getStaffContract().getContractType().getState().getCountry().getCountryId());
        staffDto.setContractTypeCountry(staff.getStaffContract().getContractType().getState().getCountry().getCountryName());
        staffDto.setContractTypeStateId(staff.getStaffContract().getContractType().getState().get_id());
        staffDto.setContractTypeState(staff.getStaffContract().getContractType().getState().getStateName());
        staffDto.setLegalCategoryTypeId(staff.getStaffContract().getLegalCategoryType().get_id());
        staffDto.setLegelCategoryTypeName(staff.getStaffContract().getLegalCategoryType().getName());
        staffDto.setInternalRulesDoc(staff.getStaffContract().getInternalRulesDoc());
        staffDto.setContractDoc(staff.getStaffContract().getContractDoc());
        staffDto.setPreContractDoc(staff.getStaffContract().getPreContractDoc());
        staffDto.setCreatedAt(staff.getStaffContract().getCreatedAt());
        // Economic contract
        staffDto.setStaffEconomicContractInformationId(staff.getStaffEconomicContractInformation().getStaffEconomicContractInformationId());
        staffDto.setContractSalary(staff.getStaffEconomicContractInformation().getContractSalary());
        staffDto.setCompanyContractCost(staff.getStaffEconomicContractInformation().getCompanyContractCost());
        staffDto.setExpenses(staff.getStaffEconomicContractInformation().getExpenses());
        staffDto.setCompanyExpensesCost(staff.getStaffEconomicContractInformation().getCompanyExpensesCost());
        staffDto.setObjectives(staff.getStaffEconomicContractInformation().getObjectives());
        staffDto.setCompanyObjectivesCost(staff.getStaffEconomicContractInformation().getCompanyObjectivesCost());
        staffDto.setTotalCompanyCost(staff.getStaffEconomicContractInformation().getTotalCompanyCost());
        staffDto.setContractSalaryDateGoing(staff.getStaffEconomicContractInformation().getContractSalaryDateGoing());
        staffDto.setContractSalaryDateOut(staff.getStaffEconomicContractInformation().getContractSalaryDateOut());
        staffDto.setCompanyContractCostDateGoing(staff.getStaffEconomicContractInformation().getCompanyContractCostDateGoing());
        staffDto.setCompanyContractCostDateOut(staff.getStaffEconomicContractInformation().getCompanyContractCostDateOut());
        staffDto.setExpensesDateGoing(staff.getStaffEconomicContractInformation().getExpensesDateGoing());
        staffDto.setExpensesDateOut(staff.getStaffEconomicContractInformation().getExpensesDateOut());
        staffDto.setCompanyExpensesCostDateGoing(staff.getStaffEconomicContractInformation().getCompanyExpensesCostDateGoing());
        staffDto.setCompanyExpensesCostDateOut(staff.getStaffEconomicContractInformation().getCompanyExpensesCostDateOut());
        staffDto.setObjectivesDateGoing(staff.getStaffEconomicContractInformation().getObjectivesDateGoing());
        staffDto.setObjectivesDateOut(staff.getStaffEconomicContractInformation().getObjectivesDateOut());
        staffDto.setCompanyObjectivesCostDateGoing(staff.getStaffEconomicContractInformation().getCompanyObjectivesCostDateGoing());
        staffDto.setCompanyObjectivesCostDateOut(staff.getStaffEconomicContractInformation().getCompanyObjectivesCostDateOut());
        staffDto.setTotalCompanyCostDateGoing(staff.getStaffEconomicContractInformation().getTotalCompanyCostDateGoing());
        staffDto.setTotalCompanyCostDateOut(staff.getStaffEconomicContractInformation().getTotalCompanyCostDateOut());
        // Functional Structure Level
        if(staff.getLevel() != null) {

            staffDto.setLevelId(staff.getLevel().get_id());
            staffDto.setLevelName(staff.getLevel().getName());
            staffDto.setLevelDescription(staff.getLevel().getDescription());
            staffDto.setLevelType(staff.getLevel().getType());
            staffDto.setIsProductionLevel(staff.getLevel().getIsProductionLevel());
            staffDto.setIsCommercialLevel(staff.getLevel().getIsCommercialLevel());
        }
        return  staffDto;

    }

}
