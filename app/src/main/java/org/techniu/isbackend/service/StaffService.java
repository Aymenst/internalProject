package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface StaffService {
    Staff saveStaff(Staff staff , Address address, String cityId);
    Staff updateStaff(Staff staff);
    String deleteStaff(String staffId);
    List<StaffDto> getAllStaffs();
    List<Staff> getAllNotAssignedStaffs();
    void assignLevelToStaff(List<Object> objects);
    List<Staff> getStaffsByLevel(String levelId);
    List<Staff> getStaffByCountry(String countryId);
}
