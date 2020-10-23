package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.StaffMapper;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.*;
import org.techniu.isbackend.repository.*;
import org.techniu.isbackend.service.utilities.StringUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;
    private AddressRepository addressRepository;
    private CityRepository cityRepository;
    private FunctionalStructureLevelRepository functionalStructureLevelRepository;
    private AddressService addressService;
    private final StaffMapper staffMapper = Mappers.getMapper(StaffMapper.class);
    private IdentificatorRepository identificatorRepository;
    StaffServiceImpl(
            CityRepository cityRepository,
            StaffRepository staffRepository,
            AddressRepository addressRepository,
            FunctionalStructureLevelRepository functionalStructureLevelRepository,
            IdentificatorRepository identificatorRepository,
            AddressService addressService) {
        this.staffRepository = staffRepository;
        this.addressRepository = addressRepository;
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.identificatorRepository = identificatorRepository;
        this.addressService = addressService;
        this.cityRepository = cityRepository;
    }

    @Override
    public Staff saveStaff(Staff staff,Address address,String cityId) {
       City city = cityRepository.findCityBy_id(cityId);
        staff.setAddress(addressService.saveAddress(address.setCity(city)));
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
    public List<StaffDto> getAllStaffs() {
        // Get all staffs
        List<Staff> staffs = staffRepository.findAll();
        // Create a list of all staff dto
        ArrayList<StaffDto> staffDtos = new ArrayList<>();
        for (Staff staff : staffs) {
            StaffDto staffDto = staffMapper.modelToDto(staff);
            staffDto.setAddressName(staff.getAddress().getFullAddress());
            staffDto.setPostCode(staff.getAddress().getPostCode());
            staffDto.setCityName(staff.getAddress().getCity().getCityName());
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
    public List<Staff> getStaffsByLevel(String levelId) {
        FunctionalStructureLevel level = functionalStructureLevelRepository.findById(levelId).get();
        List<Staff> staffs = staffRepository.findAllByLevel(level);
        return staffs;
    }

    @Override
    public List<Staff> getStaffByCountry(String countryId) {
        System.out.println(staffRepository.findAll());
        return staffRepository.findAll().stream().filter(people -> people.getAddress().getCity().getStateCountry().getCountry().getCountryId().equals(countryId)).collect(Collectors.toList());
    }

}
