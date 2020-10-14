package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.repository.AssignmentRepository;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.List;
@Service
@Transactional
public class AssignmentServiceImpl implements AssignmentService {
    private AssignmentRepository assignmentRepository;
    private StaffRepository staffRepository;
    private  ClientRepository clientRepository;
    AssignmentServiceImpl(AssignmentRepository assignmentRepository, StaffRepository staffRepository,
                          ClientRepository clientRepository) {
        this.assignmentRepository = assignmentRepository;
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public Assignment saveAssignment(Assignment assignment) {
        if (staffRepository.existsById(assignment.getStaff().get_id())
            && clientRepository.existsById(assignment.getClient().get_id())) {
            if (assignment.getType().equals("Responsible Commercial")) {
                assignment.getClient().setResponsibleCommercial(assignment.getStaff());
            } else {
                assignment.getClient().setAssistantCommercial(assignment.getStaff());
            }
            clientRepository.save(assignment.getClient());
            return assignmentRepository.save(assignment);
        } else {
            throw new ExceptionMessage("Cannot save assignment");
        }
    }

    @Override
    public Assignment updateAssignment(String assignmentId, Assignment assignment) {
        return assignmentRepository.findById(assignmentId).map(assignment1 -> {
                assignment.setAssignmentId(assignment1.getAssignmentId());
                return assignmentRepository.save(assignment);
        }).orElseThrow(() -> new ExceptionMessage("Cannot save assignment"));
    }

    @Override
    public ResponseEntity<?> deleteAssignment(String assignmentId) {
        return null;
    }

    @Override
    public List<Assignment> getAllAssignment() {
        return null;
    }

    @Override
    public List<Assignment> getAssignmentByClient(String clientId) {
        return clientRepository.findById(clientId).map(client -> assignmentRepository.findByClient(client)).orElseThrow(() -> new ExceptionMessage("Cannot get assignment by client"));
    }

    @Override
    public List<Assignment> getAssignmentByPeople(String staffId) {
        return staffRepository.findById(staffId).map(staff -> assignmentRepository.findByStaff(staff)).orElseThrow(() -> new ExceptionMessage("Cannot get assignment by Commercial"));
    }
}
