package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.FunctionalStructureAssignationHistoryMapper;
import org.techniu.isbackend.dto.model.FunctionalStructureAssignationHistoryDto;
import org.techniu.isbackend.entity.FunctionalStructureAssignationHistory;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.FunctionalStructureAssignationHistoryRepository;
import org.techniu.isbackend.repository.FunctionalStructureLevelRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FunctionalStructureAssignationHistoryServiceImpl implements FunctionalStructureAssignationHistoryService {

    private FunctionalStructureAssignationHistoryRepository functionalStructureAssignationHistoryRepository;
    private FunctionalStructureLevelRepository functionalStructureLevelRepository;
    private StaffRepository staffRepository;

    private final FunctionalStructureAssignationHistoryMapper functionalStructureAssignationHistoryMapper = Mappers.getMapper(FunctionalStructureAssignationHistoryMapper.class);

    FunctionalStructureAssignationHistoryServiceImpl(
            FunctionalStructureAssignationHistoryRepository functionalStructureAssignationHistoryRepository,
            FunctionalStructureLevelRepository functionalStructureLevelRepository,
            StaffRepository staffRepository) {
        this.functionalStructureAssignationHistoryRepository = functionalStructureAssignationHistoryRepository;
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public void deleteFunctionalStructureAssignationHistory(String functionalStructureAssignationHistoryId) {
        FunctionalStructureAssignationHistory functionalStructureAssignationHistory = functionalStructureAssignationHistoryRepository.findById(functionalStructureAssignationHistoryId).get();
        functionalStructureAssignationHistoryRepository.delete(functionalStructureAssignationHistory);
    }


    @Override
    public List<FunctionalStructureAssignationHistoryDto> getAllFunctionalStructureAssignationHistory() {
        List<FunctionalStructureAssignationHistory> functionalStructureAssignationHistories = functionalStructureAssignationHistoryRepository.findAll();
        // Create a list of all staff dto
        ArrayList<FunctionalStructureAssignationHistoryDto> functionalStructureAssignationHistoryDtos = new ArrayList<>();
        for (FunctionalStructureAssignationHistory functionalStructureAssignationHistory : functionalStructureAssignationHistories) {

            functionalStructureAssignationHistoryDtos.add(functionalStructureAssignationHistoryToDto(functionalStructureAssignationHistory));
        }
        return functionalStructureAssignationHistoryDtos;
    }

    @Override
    public List<FunctionalStructureAssignationHistoryDto> getFunctionalStructureAssignationHistoryByLevel(String levelId) {
        FunctionalStructureLevel level = functionalStructureLevelRepository.findById(levelId).get();
        List<FunctionalStructureAssignationHistory> functionalStructureAssignationHistories = functionalStructureAssignationHistoryRepository.findAllByLevel(level);
        // Create a list of all staff dto
        ArrayList<FunctionalStructureAssignationHistoryDto> functionalStructureAssignationHistoryDtos = new ArrayList<>();
        for (FunctionalStructureAssignationHistory functionalStructureAssignationHistory : functionalStructureAssignationHistories) {

            functionalStructureAssignationHistoryDtos.add(functionalStructureAssignationHistoryToDto(functionalStructureAssignationHistory));
        }
        return functionalStructureAssignationHistoryDtos;
    }

    @Override
    public List<FunctionalStructureAssignationHistoryDto> getFunctionalStructureAssignationHistoryByStaff(String staffId) {
        Staff staff = staffRepository.findById(staffId).get();
        List<FunctionalStructureAssignationHistory> functionalStructureAssignationHistories = functionalStructureAssignationHistoryRepository.findAllByStaff(staff);
        // Create a list of all staff dto
        ArrayList<FunctionalStructureAssignationHistoryDto> functionalStructureAssignationHistoryDtos = new ArrayList<>();
        for (FunctionalStructureAssignationHistory functionalStructureAssignationHistory : functionalStructureAssignationHistories) {

            functionalStructureAssignationHistoryDtos.add(functionalStructureAssignationHistoryToDto(functionalStructureAssignationHistory));
        }
        return functionalStructureAssignationHistoryDtos;
    }


    public FunctionalStructureAssignationHistoryDto functionalStructureAssignationHistoryToDto(FunctionalStructureAssignationHistory functionalStructureAssignationHistory) {
        FunctionalStructureAssignationHistoryDto functionalStructureAssignationHistoryDto = functionalStructureAssignationHistoryMapper.modelToDto(functionalStructureAssignationHistory);
        System.out.println(functionalStructureAssignationHistory);
        functionalStructureAssignationHistoryDto.setFunctionalStructureAssignationHistoryId(functionalStructureAssignationHistory.get_id());
        functionalStructureAssignationHistoryDto.setLevelId(functionalStructureAssignationHistory.getLevel().get_id());
        functionalStructureAssignationHistoryDto.setLevelName(functionalStructureAssignationHistory.getLevel().getName());
        functionalStructureAssignationHistoryDto.setLevelType(functionalStructureAssignationHistory.getLevel().getType());
        functionalStructureAssignationHistoryDto.setStaffId(functionalStructureAssignationHistory.getStaff().getStaffId());
        functionalStructureAssignationHistoryDto.setStaffName(
                functionalStructureAssignationHistory.getStaff().getFirstName() + ' '
                + functionalStructureAssignationHistory.getStaff().getFatherFamilyName() + ' '
                + functionalStructureAssignationHistory.getStaff().getMotherFamilyName()
        );
        return functionalStructureAssignationHistoryDto;
    }
}
