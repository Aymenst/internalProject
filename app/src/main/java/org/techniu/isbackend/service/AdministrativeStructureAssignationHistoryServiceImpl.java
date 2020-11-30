package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.AdministrativeStructureAssignationHistoryMapper;
import org.techniu.isbackend.dto.model.AdministrativeStructureAssignationHistoryDto;
import org.techniu.isbackend.entity.AdministrativeStructureAssignationHistory;
import org.techniu.isbackend.entity.AdministrativeStructureLevel;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.AdministrativeStructureAssignationHistoryRepository;
import org.techniu.isbackend.repository.AdministrativeStructureLevelRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AdministrativeStructureAssignationHistoryServiceImpl implements AdministrativeStructureAssignationHistoryService {

    private AdministrativeStructureAssignationHistoryRepository administrativeStructureAssignationHistoryRepository;
    private AdministrativeStructureLevelRepository administrativeStructureLevelRepository;
    private StaffRepository staffRepository;

    private final AdministrativeStructureAssignationHistoryMapper administrativeStructureAssignationHistoryMapper = Mappers.getMapper(AdministrativeStructureAssignationHistoryMapper.class);

    AdministrativeStructureAssignationHistoryServiceImpl(
            AdministrativeStructureAssignationHistoryRepository administrativeStructureAssignationHistoryRepository,
            AdministrativeStructureLevelRepository administrativeStructureLevelRepository,
            StaffRepository staffRepository) {
        this.administrativeStructureAssignationHistoryRepository = administrativeStructureAssignationHistoryRepository;
        this.administrativeStructureLevelRepository = administrativeStructureLevelRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public void deleteAdministrativeStructureAssignationHistory(String administrativeStructureAssignationHistoryId) {
        AdministrativeStructureAssignationHistory administrativeStructureAssignationHistory = administrativeStructureAssignationHistoryRepository.findById(administrativeStructureAssignationHistoryId).get();
        administrativeStructureAssignationHistoryRepository.delete(administrativeStructureAssignationHistory);
    }


    @Override
    public List<AdministrativeStructureAssignationHistoryDto> getAllAdministrativeStructureAssignationHistory() {
        List<AdministrativeStructureAssignationHistory> administrativeStructureAssignationHistories = administrativeStructureAssignationHistoryRepository.findAll();
        // Create a list of all staff dto
        ArrayList<AdministrativeStructureAssignationHistoryDto> administrativeStructureAssignationHistoryDtos = new ArrayList<>();
        for (AdministrativeStructureAssignationHistory administrativeStructureAssignationHistory : administrativeStructureAssignationHistories) {

            administrativeStructureAssignationHistoryDtos.add(administrativeStructureAssignationHistoryToDto(administrativeStructureAssignationHistory));
        }
        return administrativeStructureAssignationHistoryDtos;
    }

    @Override
    public List<AdministrativeStructureAssignationHistoryDto> getAdministrativeStructureAssignationHistoryByLevel(String levelId) {
        AdministrativeStructureLevel level = administrativeStructureLevelRepository.findById(levelId).get();
        List<AdministrativeStructureAssignationHistory> administrativeStructureAssignationHistories = administrativeStructureAssignationHistoryRepository.findAllByLevel(level);
        // Create a list of all staff dto
        ArrayList<AdministrativeStructureAssignationHistoryDto> administrativeStructureAssignationHistoryDtos = new ArrayList<>();
        for (AdministrativeStructureAssignationHistory administrativeStructureAssignationHistory : administrativeStructureAssignationHistories) {

            administrativeStructureAssignationHistoryDtos.add(administrativeStructureAssignationHistoryToDto(administrativeStructureAssignationHistory));
        }
        return administrativeStructureAssignationHistoryDtos;
    }

    @Override
    public List<AdministrativeStructureAssignationHistoryDto> getAdministrativeStructureAssignationHistoryByStaff(String staffId) {
        Staff staff = staffRepository.findById(staffId).get();
        List<AdministrativeStructureAssignationHistory> administrativeStructureAssignationHistories = administrativeStructureAssignationHistoryRepository.findAllByStaff(staff);
        // Create a list of all staff dto
        ArrayList<AdministrativeStructureAssignationHistoryDto> administrativeStructureAssignationHistoryDtos = new ArrayList<>();
        for (AdministrativeStructureAssignationHistory administrativeStructureAssignationHistory : administrativeStructureAssignationHistories) {

            administrativeStructureAssignationHistoryDtos.add(administrativeStructureAssignationHistoryToDto(administrativeStructureAssignationHistory));
        }
        return administrativeStructureAssignationHistoryDtos;
    }


    public AdministrativeStructureAssignationHistoryDto administrativeStructureAssignationHistoryToDto(AdministrativeStructureAssignationHistory administrativeStructureAssignationHistory) {
        AdministrativeStructureAssignationHistoryDto administrativeStructureAssignationHistoryDto = administrativeStructureAssignationHistoryMapper.modelToDto(administrativeStructureAssignationHistory);
        System.out.println(administrativeStructureAssignationHistory);
        administrativeStructureAssignationHistoryDto.setAdministrativeStructureAssignationHistoryId(administrativeStructureAssignationHistory.get_id());
        administrativeStructureAssignationHistoryDto.setLevelId(administrativeStructureAssignationHistory.getLevel().get_id());
        administrativeStructureAssignationHistoryDto.setLevelName(administrativeStructureAssignationHistory.getLevel().getName());
        administrativeStructureAssignationHistoryDto.setLevelType(administrativeStructureAssignationHistory.getLevel().getType());
        administrativeStructureAssignationHistoryDto.setStaffId(administrativeStructureAssignationHistory.getStaff().getStaffId());
        administrativeStructureAssignationHistoryDto.setStaffName(
                administrativeStructureAssignationHistory.getStaff().getFirstName() + ' '
                + administrativeStructureAssignationHistory.getStaff().getFatherFamilyName() + ' '
                + administrativeStructureAssignationHistory.getStaff().getMotherFamilyName()
        );
        return administrativeStructureAssignationHistoryDto;
    }
}
