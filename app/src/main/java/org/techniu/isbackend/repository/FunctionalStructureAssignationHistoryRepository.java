package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.*;

import java.util.List;

public interface FunctionalStructureAssignationHistoryRepository extends MongoRepository<FunctionalStructureAssignationHistory, String> {

        List<FunctionalStructureAssignationHistory> findAllByStaff(Staff staff);

        List<FunctionalStructureAssignationHistory> findAllByLevel(FunctionalStructureLevel level);
}
