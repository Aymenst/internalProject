package org.techniu.isbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.FunctionalStructureLevelConfig;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.FunctionalStructureLevelConfigRepository;
import org.techniu.isbackend.repository.FunctionalStructureLevelRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FunctionalStructureLevelServiceImpl implements FunctionalStructureLevelService {
    private FunctionalStructureLevelRepository functionalStructureLevelRepository;
    private FunctionalStructureLevelConfigRepository levelConfigRepository;
    private StaffRepository staffRepository;
    FunctionalStructureLevelServiceImpl(FunctionalStructureLevelRepository functionalStructureLevelRepository, StaffRepository staffRepository, FunctionalStructureLevelConfigRepository levelConfigRepository) {
        this.functionalStructureLevelRepository = functionalStructureLevelRepository;
        this.staffRepository = staffRepository;
        this.levelConfigRepository = levelConfigRepository;
    }
    @Override
    public Boolean saveLevel(List<Object> objects) {
        ObjectMapper mapper = new ObjectMapper();
        FunctionalStructureLevelConfig levelConfig = mapper.convertValue(objects.get(0), FunctionalStructureLevelConfig.class);
        FunctionalStructureLevel level1 = mapper.convertValue(objects.get(1), FunctionalStructureLevel.class);
        FunctionalStructureLevel level2 = mapper.convertValue(objects.get(2), FunctionalStructureLevel.class);
        FunctionalStructureLevel level3 = mapper.convertValue(objects.get(3), FunctionalStructureLevel.class);
        FunctionalStructureLevel lvl1 = functionalStructureLevelRepository.findByName(level1.getName());
        FunctionalStructureLevel lvl2 = functionalStructureLevelRepository.findByName(level2.getName());
        FunctionalStructureLevel lvl3 = functionalStructureLevelRepository.findByName(level3.getName());
        if(lvl1 != null) {
            level2.setParent(lvl1);
        }
        else {
            level2.setParent(functionalStructureLevelRepository.save(level1));
            level3.setParent(functionalStructureLevelRepository.save(level2));
            functionalStructureLevelRepository.save(level3);
        };
        if(lvl1 != null) {
            level2.setParent(lvl1);
        }
        else {
            level2.setParent(functionalStructureLevelRepository.save(level1));

        };
        if(lvl2 != null) {
            level3.setParent(lvl2);
        }
        else {
            level3.setParent(functionalStructureLevelRepository.save(level2));

        };
        if(lvl3 == null) {
            functionalStructureLevelRepository.save(level3);
            levelConfigRepository.save(levelConfig);
        }
        return true;
    }

    @Override
    public FunctionalStructureLevel updateLevel(FunctionalStructureLevel level) {
        return null;
    }

    @Override
    public FunctionalStructureLevel getLevelByName(String name) {
        return this.functionalStructureLevelRepository.findByName(name);
    }

    @Override
    public ResponseEntity<?> deleteLevel(String levelId) {
        return null;
    }

    @Override
    public List<FunctionalStructureLevel> getAllLevels() {
        return  this.functionalStructureLevelRepository.findAll();
    }

    @Override
    public List<FunctionalStructureLevel> getLevelByParent(String name) {
        FunctionalStructureLevel s = functionalStructureLevelRepository.findByName(name);
        if (s != null) {
            return functionalStructureLevelRepository.findByParent(s);
        } else {
            throw new ExceptionMessage("Cannot get Level");
        }
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
}
