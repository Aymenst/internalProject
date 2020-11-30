package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.AdministrativeStructureAssignationHistory;
import org.techniu.isbackend.entity.AdministrativeStructureLevel;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface AdministrativeStructureAssignationHistoryRepository extends MongoRepository<AdministrativeStructureAssignationHistory, String> {

        List<AdministrativeStructureAssignationHistory> findAllByStaff(Staff staff);

        List<AdministrativeStructureAssignationHistory> findAllByLevel(AdministrativeStructureLevel level);
}
