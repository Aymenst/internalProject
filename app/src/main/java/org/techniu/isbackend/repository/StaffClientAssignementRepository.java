package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.techniu.isbackend.entity.StaffClientAssignment;

import java.util.List;

@Repository
public interface StaffClientAssignementRepository extends MongoRepository<StaffClientAssignment, String> {
    StaffClientAssignment getBy_id(String id);
}
