package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.*;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff, City city, StaffEconomicContractInformation staffEconomicContractInformation, StaffContract staffContract, List<StaffDocuments> staffDocumentsList);
    Staff updateStaff(String staffId, String cityId, Staff staff);
    String deleteStaff(String staffId);
    List<Staff> getAllStaffs();
    Staff getStaffById( String staffId);
    List<StaffDto> getAll();
    List<Staff> getAllNotAssignedStaffs();
    void assignLevelToStaff(List<Object> objects);
    List<Staff> getStaffsByLevel(String levelId, String isLeader);
    Staff save(StaffDto staffDto, String cityId, Address address, StaffEconomicContractInformation staffEconomicContractInformation, StaffContract staffContract, List<StaffDocuments> staffDocumentsList);
}
