package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.FunctionalStructureLevelRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FunctionalStructureLevelServiceImpl implements FunctionalStructureLevelService {
    private FunctionalStructureLevelRepository functionalStructureLevelRepository;
    private StaffRepository staffRepository;
    FunctionalStructureLevelServiceImpl(FunctionalStructureLevelRepository functionalStructureLevelRepository, StaffRepository staffRepository) {
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffRepository = staffRepository;
    }
    @Override
    public Boolean saveLevel(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        List<FunctionalStructureLevel> list = new ArrayList<>();
        List<Staff> leaders  = mapper.convertValue(objects.get(0), new TypeReference<List<Staff>>() { });
        for (int i=1; i < objects.size(); i++) {
            FunctionalStructureLevel level = mapper.convertValue(objects.get(i), FunctionalStructureLevel.class);
            FunctionalStructureLevel lvl = functionalStructureLevelRepository.findByName(level.getName());
            Staff staff = leaders.get(i-1);
            staff.setIsLeader("yes");
            if (lvl == null) {
                lvl = functionalStructureLevelRepository.save(level);
            }
            staff.setLevel(lvl);
            staffRepository.save(staff);
            list.add(lvl);
        }
        for (int i=list.size()-1; i > 0; i--) {
            FunctionalStructureLevel level = list.get(i-1);
            System.out.println("list");
            System.out.println(list);
            System.out.println("level");
            System.out.println("list.size()");
            System.out.println(list.size());
            System.out.println("i");
            System.out.println(i);
            List<FunctionalStructureLevel> childs = new ArrayList<>();
            if(level.getChilds() == null){
                childs.add(list.get(i));
            }
            else {
                childs = level.getChilds();
                boolean exist = false;
                for (int j = 0; j < childs.size(); j++) {

                    if (level.getChilds().get(j).getLevelId().equals(list.get(i).getLevelId())) {
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
    public FunctionalStructureLevel updateLevel(List<Object> objects, String levelId) {
        ObjectMapper mapper = new ObjectMapper();
        Staff oldLeader = mapper.convertValue(objects.get(0), Staff.class);
        Staff newLeader = mapper.convertValue(objects.get(1), Staff.class);
        FunctionalStructureLevel level = mapper.convertValue(objects.get(2), FunctionalStructureLevel.class);
        if(oldLeader != null) {
            oldLeader.setLevel(null);
            oldLeader.setIsLeader("no");
            staffRepository.save(oldLeader);
        }
        level.setLevelId(levelId);
        newLeader.setLevel(functionalStructureLevelRepository.save(level));
        newLeader.setIsLeader("yes");
        staffRepository.save(newLeader);
        return null;
    }

    @Override
    public FunctionalStructureLevel getLevelByName(String name) {
        return this.functionalStructureLevelRepository.findByName(name);
    }

    @Override
    public ResponseEntity<?> deleteLevel(String levelId) {
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
    public List<FunctionalStructureLevel> getAllLevels() {
        return  this.functionalStructureLevelRepository.findAll();
    }

    @Override
    public List<FunctionalStructureLevel> getLevelByType(String type) {
        return functionalStructureLevelRepository.findByType(type);
    }

    @Override
    public List<Staff> setLevelStaffs(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        FunctionalStructureLevel functionalStructureLevel = mapper.convertValue(objects.get(0), FunctionalStructureLevel.class);
        List<Staff> staffs = mapper.convertValue(objects.get(1), new TypeReference<List<Staff>>(){});
        Optional<FunctionalStructureLevel> level = functionalStructureLevelRepository.findById(functionalStructureLevel.getLevelId());
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
        System.out.println(level.getType());
        if(level.getType().equals("Level 1")) {
            list.add(level);
        } else if(level.getType().equals("Level 2")) {
            System.out.println("test Condtion");
            FunctionalStructureLevel level1 = functionalStructureLevelRepository.findByChildsContaining(level);
            System.out.println(level1);
            list.add(level1);
            System.out.println("added");
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
}
