package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.controller.request.FunctionalStructureLevelAddrequest;
import org.techniu.isbackend.dto.mapper.FunctionalStructureLevelMapper;
import org.techniu.isbackend.dto.model.FunctionalStructureLevelDto;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.exception.EntityType;
import org.techniu.isbackend.exception.ExceptionType;
import org.techniu.isbackend.exception.MainException;
import org.techniu.isbackend.repository.FunctionalStructureLevelRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.techniu.isbackend.exception.ExceptionType.DUPLICATE_ENTITY;

@Service
@Transactional
public class FunctionalStructureLevelServiceImpl implements FunctionalStructureLevelService {
    private FunctionalStructureLevelRepository functionalStructureLevelRepository;
    private StaffRepository staffRepository;
    private final FunctionalStructureLevelMapper functionalStructureLevelMapper = Mappers.getMapper(FunctionalStructureLevelMapper.class);
    FunctionalStructureLevelServiceImpl(
            FunctionalStructureLevelRepository functionalStructureLevelRepository,
            StaffRepository staffRepository) {
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffRepository = staffRepository;
    }
    @Override
    public Boolean save(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        List<FunctionalStructureLevel> list = new ArrayList<>();
        List<StaffDto> leaders  = mapper.convertValue(objects.get(0), new TypeReference<List<StaffDto>>() { });
        for (int i=1; i < objects.size(); i++) {
            FunctionalStructureLevelAddrequest levelAddrequest = mapper.convertValue(objects.get(i), FunctionalStructureLevelAddrequest.class);
            FunctionalStructureLevelDto levelDto = functionalStructureLevelMapper.addRequestToDto(levelAddrequest);
            FunctionalStructureLevel lvl = functionalStructureLevelRepository.findByName(levelDto.getName());
            if (lvl == null) {
                StaffDto staffDto = leaders.get(i-1);
                Staff staff1 = staffRepository.findById(staffDto.getStaffId()).get();
                staff1.setIsLeader("yes");
                lvl = functionalStructureLevelRepository.save(functionalStructureLevelMapper.dtoToModel(levelDto));
                staff1.setLevel(lvl);
                System.out.println(staff1);
                staffRepository.save(staff1);
            }
            list.add(lvl);
        }
        for (int i=list.size()-1; i > 0; i--) {
            FunctionalStructureLevel level = list.get(i-1);
            List<FunctionalStructureLevel> childs = new ArrayList<>();
            if(level.getChilds() == null){
                childs.add(list.get(i));
            }
            else {
                childs = level.getChilds();
                boolean exist = false;
                for (int j = 0; j < childs.size(); j++) {

                    if (level.getChilds().get(j).get_id().equals(list.get(i).get_id())) {
                        exist = true;
                        break;
                    }
                }
                if(!exist) {
                    childs.add(list.get(i));
                }
            }
            level.setChilds(childs);
            list.set(i-1,functionalStructureLevelRepository.save(level));
        }
        return true;
    }

    @Override
    public FunctionalStructureLevel update(FunctionalStructureLevelDto functionalStructureLevelDto, String oldLeaderId, String newLeaderId) {
        Staff oldLeader = staffRepository.findById(oldLeaderId).get();
        Staff newLeader = staffRepository.findById(newLeaderId).get();
        FunctionalStructureLevel functionalStructureLevel = functionalStructureLevelRepository.findById(functionalStructureLevelDto.getLevelId()).get();
        if(oldLeader != null) {
            oldLeader.setLevel(null);
            oldLeader.setIsLeader("no");
            staffRepository.save(oldLeader);
        }
        FunctionalStructureLevel functionalStructureLevel1 = functionalStructureLevelMapper.dtoToModel(functionalStructureLevelDto);
        functionalStructureLevel1.setChilds(functionalStructureLevel.getChilds());
        newLeader.setLevel(functionalStructureLevelRepository.save(functionalStructureLevel1));
        newLeader.setIsLeader("yes");
        staffRepository.save(newLeader);
        return null;
    }

    @Override
    public FunctionalStructureLevel getLevelByName(String name) {
        return this.functionalStructureLevelRepository.findByName(name);
    }

    @Override
    public ResponseEntity<?> remove(String levelId) {
        FunctionalStructureLevel level = functionalStructureLevelRepository.findById(levelId).get();
        if(level.getChilds() != null) {
            List<FunctionalStructureLevel> list1 = level.getChilds();
            list1.forEach(level2 -> {
                if(level2.getChilds() != null ) {
                    List<FunctionalStructureLevel> list2 = level2.getChilds();
                    list2.forEach(level3 -> {
                        List<Staff> staffs = staffRepository.findAllByLevelAndIsLeader(level3, "no");
                        staffs.addAll(staffRepository.findAllByLevelAndIsLeader(level3, "yes"));
                        staffs.forEach(staff -> {
                            staff.setIsLeader("no");
                            staff.setLevel(null);
                            staffRepository.save(staff);
                        });
                        functionalStructureLevelRepository.delete(level3);
                    });
                }
                List<Staff> staffs = staffRepository.findAllByLevelAndIsLeader(level2, "no");
                staffs.addAll(staffRepository.findAllByLevelAndIsLeader(level2, "yes"));
                staffs.forEach(staff -> {
                    staff.setIsLeader("no");
                    staff.setLevel(null);
                    staffRepository.save(staff);
                });
                functionalStructureLevelRepository.delete(level2);
            });
        }
        List<Staff> staffs = staffRepository.findAllByLevelAndIsLeader(level, "no");
        staffs.addAll(staffRepository.findAllByLevelAndIsLeader(level, "yes"));
        staffs.forEach(staff -> {
            staff.setIsLeader("no");
            staff.setLevel(null);
            staffRepository.save(staff);
        });
        FunctionalStructureLevel parent = functionalStructureLevelRepository.findByChildsContaining(level);
        if(parent != null) {
            parent.setChilds(null);
            functionalStructureLevelRepository.save(parent);
        }
        functionalStructureLevelRepository.delete(level);
        return null;
    }

    @Override
    public List<FunctionalStructureLevelDto> getAll() {
        List<FunctionalStructureLevel> functionalStructureLevels = functionalStructureLevelRepository.findAll();
        // Create a list of all actions dto
        List<FunctionalStructureLevelDto> functionalStructureLevelDtos = new ArrayList<>();

        for (FunctionalStructureLevel level : functionalStructureLevels) {
            FunctionalStructureLevelDto functionalStructureLevelDto=functionalStructureLevelMapper.modelToDto(level);
            List<FunctionalStructureLevel> functionalStructureLevels1 = level.getChilds();
            if(functionalStructureLevels1 != null){
                List<FunctionalStructureLevelDto> functionalStructureLevelDtos1 = new ArrayList<>();
                for (FunctionalStructureLevel level1 : functionalStructureLevels1) {
                    FunctionalStructureLevelDto functionalStructureLevelDto1 = functionalStructureLevelMapper.modelToDto(level1);
                    List<FunctionalStructureLevel> functionalStructureLevels2 = level1.getChilds();
                    List<FunctionalStructureLevelDto> functionalStructureLevelDtos2 = new ArrayList<>();
                    if (functionalStructureLevels2 != null) {
                        for (FunctionalStructureLevel level2 : functionalStructureLevels2) {
                            FunctionalStructureLevelDto functionalStructureLevelDto2 = functionalStructureLevelMapper.modelToDto(level2);
                            functionalStructureLevelDtos2.add(functionalStructureLevelDto2);
                        }
                        functionalStructureLevelDto1.setChilds(functionalStructureLevelDtos2);
                    }
                    functionalStructureLevelDtos1.add(functionalStructureLevelDto1);
                }
                functionalStructureLevelDto.setChilds(functionalStructureLevelDtos1);
            }
            functionalStructureLevelDtos.add(functionalStructureLevelDto);
        }
        return functionalStructureLevelDtos;
    }

    @Override
    public List<FunctionalStructureLevelDto> getAllByType(String type) {
        List<FunctionalStructureLevel> functionalStructureLevels = functionalStructureLevelRepository.findByType(type);
        // Create a list of all actions dto
        List<FunctionalStructureLevelDto> functionalStructureLevelDtos = new ArrayList<>();

        for (FunctionalStructureLevel level : functionalStructureLevels) {
            FunctionalStructureLevelDto functionalStructureLevelDto=functionalStructureLevelMapper.modelToDto(level);
            List<FunctionalStructureLevel> functionalStructureLevels1 = level.getChilds();
            if(functionalStructureLevels1 != null){
                List<FunctionalStructureLevelDto> functionalStructureLevelDtos1 = new ArrayList<>();
                for (FunctionalStructureLevel level1 : functionalStructureLevels1) {
                    FunctionalStructureLevelDto functionalStructureLevelDto1 = functionalStructureLevelMapper.modelToDto(level1);
                    List<FunctionalStructureLevel> functionalStructureLevels2 = level1.getChilds();
                    List<FunctionalStructureLevelDto> functionalStructureLevelDtos2 = new ArrayList<>();
                    if (functionalStructureLevels2 != null) {
                        for (FunctionalStructureLevel level2 : functionalStructureLevels2) {
                            FunctionalStructureLevelDto functionalStructureLevelDto2 = functionalStructureLevelMapper.modelToDto(level2);
                            functionalStructureLevelDtos2.add(functionalStructureLevelDto2);
                        }
                        functionalStructureLevelDto1.setChilds(functionalStructureLevelDtos2);
                    }
                    functionalStructureLevelDtos1.add(functionalStructureLevelDto1);
                }
                functionalStructureLevelDto.setChilds(functionalStructureLevelDtos1);
            }
            functionalStructureLevelDtos.add(functionalStructureLevelDto);
        }
        return functionalStructureLevelDtos;
    }

    @Override
    public List<Staff> setLevelStaffs(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        FunctionalStructureLevel functionalStructureLevel = mapper.convertValue(objects.get(0), FunctionalStructureLevel.class);
        List<Staff> staffs = mapper.convertValue(objects.get(1), new TypeReference<List<Staff>>(){});
        Optional<FunctionalStructureLevel> level = functionalStructureLevelRepository.findById(functionalStructureLevel.get_id());
        /*if(level.isPresent()) {
            FunctionalStructureLevel level1 = level.get();
            List<Staff> list = new ArrayList<>();
            staffs.forEach(staff -> {
                Staff staff1 = staffRepository.findById(staff.getStaffId()).get();
                staff1.setLevel(level1);
                list.add(staff1);
                staffRepository.save(staff1);
            });
            level1.setStaffs(list);
            functionalStructureLevelRepository.save(level1);
        }*/
        return null;
    }

    @Override
    public List<FunctionalStructureLevel> getFunctionalStructureTree(String levelId) {
        FunctionalStructureLevel level = functionalStructureLevelRepository.findById(levelId).get();
        List<FunctionalStructureLevel> list = new ArrayList<>();
        if(level.getType().equals("Level 1")) {
            list.add(level);
        } else if(level.getType().equals("Level 2")) {
            FunctionalStructureLevel level1 = functionalStructureLevelRepository.findByChildsContaining(level);
            list.add(level1);
            list.add(level);
        } else if(level.getType().equals("Level 3")) {
            FunctionalStructureLevel level2 = functionalStructureLevelRepository.findByChildsContaining(level);
            FunctionalStructureLevel level1 = functionalStructureLevelRepository.findByChildsContaining(level2);
            list.add(level1);
            list.add(level2);
            list.add(level);
        }
        return list;
    }
    private RuntimeException exception(ExceptionType exceptionType, String... args) {
        return MainException.throwException(EntityType.FunctionalStructureLevel, exceptionType, args);
    }
}
