package org.techniu.isbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface AssignmentRepository extends MongoRepository<Assignment, String> {
    List<Assignment> findByClient(Client client);
    List<Assignment> findByStaff(Staff staff);
}
