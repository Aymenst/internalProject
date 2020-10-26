package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.mongodb.core.query.SerializationUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.repository.*;
import org.techniu.isbackend.service.utilities.StringUtility;

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
    private StaffEconomicContractInformationService staffEconomicContractInformationService;
    StaffServiceImpl(
            StaffRepository staffRepository,
            FunctionalStructureLevelRepository functionalStructureLevelRepository,
            StaffDocumentsRepository staffDocumentsRepository,
            AddressRepository addressRepository, StaffEconomicContractInformationService staffEconomicContractInformationService) {
        this.staffRepository = staffRepository;
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffDocumentsRepository = staffDocumentsRepository;
        this.addressRepository = addressRepository;
        this.staffEconomicContractInformationService = staffEconomicContractInformationService;
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
    public Staff updateStaff(Staff staff) {
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
