package org.techniu.isbackend.service;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.mapper.StaffClientAssignmentMapper;
import org.techniu.isbackend.dto.model.StaffClientAssignmentDto;
import org.techniu.isbackend.entity.Assignment;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffClientAssignment;
import org.techniu.isbackend.repository.ClientRepository;
import org.techniu.isbackend.repository.StaffClientAssignementRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StaffClientAssignmentServiceImpl implements StaffClientAssignmentService {
    private final StaffClientAssignementRepository staffClientAssignementRepository;
    private final StaffRepository staffRepository;
    private final ClientRepository clientRepository;
    private final StaffClientAssignmentMapper staffClientAssignmentMapper = Mappers.getMapper(StaffClientAssignmentMapper.class);
    public StaffClientAssignmentServiceImpl(StaffClientAssignementRepository staffClientAssignementRepository, StaffRepository staffRepository, ClientRepository clientRepository) {
        this.staffClientAssignementRepository = staffClientAssignementRepository;
        this.staffRepository = staffRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void save(StaffClientAssignmentDto staffClientAssignmentDto, String staffId, List<String> clients) {
        System.out.println(staffClientAssignementRepository.findAll());
        Optional<Staff> staff= staffRepository.findById(staffId);
        System.out.println("BBBBBBBBBB ");
        StaffClientAssignment staffClientAssignment=staffClientAssignmentMapper.dtoToModel(staffClientAssignmentDto);
        for (String clientId : clients)
        {
            Client client = clientRepository.findBy_id(clientId);
            System.out.println(staffClientAssignment.getTypeStaff());
            List<StaffClientAssignment>  StaffClientAssignmentList= staffClientAssignementRepository.findAll();
            System.out.println(StaffClientAssignmentList);
          //  Optional<StaffClientAssignment> staffClientAssignment1= staffClientAssignementRepository.findById("5fa845d1c78dd544e170f548");
          //  System.out.println("assignment "+ staffClientAssignment1.get());
            if(StaffClientAssignmentList != null){
                StaffClientAssignment  staffClientAssignment2=new StaffClientAssignment();
                System.out.println("HHHH ");
                staffClientAssignment2.setClient(client);
                staffClientAssignment2.setStaff(staff.get());
                staffClientAssignementRepository.save(staffClientAssignment2);
            }
            else {
                StaffClientAssignment  staffClientAssignmentx=new StaffClientAssignment();
                staffClientAssignmentx.setClient(client);
                staffClientAssignmentx.setStaff(staff.get());
                staffClientAssignementRepository.save(staffClientAssignmentx);
            }
        }
    }
}
