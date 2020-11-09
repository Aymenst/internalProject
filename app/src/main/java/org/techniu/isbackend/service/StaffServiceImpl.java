package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.repository.*;

import java.util.ArrayList;
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
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    private StaffEconomicContractInformationService staffEconomicContractInformationService;
    StaffServiceImpl(
            StaffRepository staffRepository,
            FunctionalStructureLevelRepository functionalStructureLevelRepository,
            StaffDocumentsRepository staffDocumentsRepository,
            StaffContractRepository staffContractRepository,
            AddressRepository addressRepository, CityRepository cityRepository, StaffEconomicContractInformationService staffEconomicContractInformationService) {
        this.staffRepository = staffRepository;
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffDocumentsRepository = staffDocumentsRepository;
        this.addressRepository = addressRepository;
        this.cityRepository = cityRepository;
        this.staffEconomicContractInformationService = staffEconomicContractInformationService;
        this.staffContractRepository = staffContractRepository;
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
    public Staff save(StaffDto staffDto, String cityId, Address address, StaffEconomicContractInformation staffEconomicContractInformation, StaffContract staffContract, List<StaffDocuments> staffDocumentsList) {
        address.setCity( cityRepository.findCityBy_id(cityId));
        Address address1 = addressRepository.save(address);
        Staff staff = staffMapper.dtoToModel(staffDto);
        staff.setAddress(address1);
        staff.setStaffContract(staffContract);
        StaffEconomicContractInformation staffEconomicContractInformation2 = staffEconomicContractInformationService.saveStaffEconomicContractInformation(staffEconomicContractInformation);
        staff.setStaffEconomicContractInformation(staffEconomicContractInformation2);
        StaffContract staffContract1 = staffContractRepository.save(staffContract);
        staff.setStaffContract(staffContract1);
        staff.setStaffDocuments(staffDocumentsRepository.saveAll(staffDocumentsList));
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
    public Staff getStaffById(String staffId) {
        return staffRepository.findById(staffId).get();
    }

    @Override
    public List<StaffDto> getAll() {
        // Get all actions
        List<Staff> staffs = staffRepository.findAll();
        // Create a list of all staff dto
        ArrayList<StaffDto> staffDtos = new ArrayList<>();

        for (Staff staff : staffs) {
            StaffDto staffDto=staffMapper.modelToDto(staff);
            staffDtos.add(staffDto);
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
        FunctionalStructureLevel functionalStructureLevel = mapper.convertValue(objects.get(0), FunctionalStructureLevel.class);
        List<Staff> assignedStaffs = mapper.convertValue(objects.get(1), new TypeReference<List<Staff>>() { });
        List<Staff> notAssignedStaffs = mapper.convertValue(objects.get(2), new TypeReference<List<Staff>>() { });
        assignedStaffs.forEach(staff -> {
            staff.setLevel(functionalStructureLevel);
            staffRepository.save(staff);
        });
        notAssignedStaffs.forEach(staff -> {
            staff.setLevel(null);
            staffRepository.save(staff);
        });
    }

    @Override
    public List<Staff> getStaffsByLevel(String levelId, String isLeader) {
        FunctionalStructureLevel level = functionalStructureLevelRepository.findById(levelId).get();
        List<Staff> staffs = staffRepository.findAllByLevelAndIsLeader(level, isLeader);
        return staffs;
    }

}
