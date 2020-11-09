package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.techniu.isbackend.dto.mapper.AssignmentMapper;
import org.techniu.isbackend.dto.model.AssignmentDto;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.repository.AssignmentRepository;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final StaffRepository staffRepository;
    private final  ClientRepository clientRepository;
    private final AssignmentMapper assignmentMapper = Mappers.getMapper(AssignmentMapper.class);
    AssignmentServiceImpl(AssignmentRepository assignmentRepository, StaffRepository staffRepository,
                          ClientRepository clientRepository) {
        this.assignmentRepository = assignmentRepository;
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
    }
    @Override
    public Assignment saveAssignment(Assignment assignment) {
        if (staffRepository.existsById(assignment.getStaff().getStaffId())
            && clientRepository.existsById(assignment.getClient().get_id())) {
            if (assignment.getTypeStaff().equals("Responsible Commercial")) {
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

    /**
     * save
     *
     * @param assignmentDto - assignmentDto
     * @param staffId     - staffId
     * @param clientsIds       - clientsIds
     */
    @Override
    public void save(AssignmentDto assignmentDto, String staffId, List<String> clientsIds) {
        Optional<Staff> staff= staffRepository.findById(staffId);
        List<Assignment>  assignmentList= assignmentRepository.findAll();
        for (String clientId : clientsIds)
        {
            Client client = clientRepository.findBy_id(clientId);
            Assignment assignmentx= assignmentRepository.findByClientAndTypeStaff(client,assignmentDto.getTypeStaff());
            if(assignmentx != null){
                assignmentx.setClient(client);
                assignmentx.setStaff(staff.get());
                assignmentRepository.save(assignmentx);
            }
            else {
                Assignment assignment=assignmentMapper.dtoToModel(assignmentDto);
                assignment.setClient(client);
                assignment.setStaff(staff.get());
                assignmentRepository.save(assignment);
            }
        }
    }

    @Override
    public Assignment updateAssignment(String assignmentId, Assignment assignment) {
        return assignmentRepository.findById(assignmentId).map(assignment1 -> {
                assignment.set_id(assignment1.get_id());
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
