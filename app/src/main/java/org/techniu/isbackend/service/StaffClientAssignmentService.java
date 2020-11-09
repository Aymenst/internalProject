package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.dto.model.AssignmentDto;
import org.techniu.isbackend.dto.model.ClientDto;
import org.techniu.isbackend.dto.model.StaffClientAssignmentDto;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.Client;

import java.util.List;

public interface StaffClientAssignmentService {
    void save(StaffClientAssignmentDto staffClientAssignmentDto, String staffId, List<String> clients);
}
