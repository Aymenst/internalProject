package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Staff;
import org.techniu.isbackend.entity.StaffDocuments;
import org.techniu.isbackend.repository.StaffDocumentsRepository;
import org.techniu.isbackend.repository.StaffRepository;

import java.util.List;

@Service
@Transactional
public class StaffDocumentsServiceImpl implements StaffDocumentsService {

    private StaffDocumentsRepository staffDocumentsRepository;
    private StaffRepository staffRepository;

    StaffDocumentsServiceImpl(StaffDocumentsRepository staffDocumentsRepository, StaffRepository staffRepository) {
        this.staffDocumentsRepository = staffDocumentsRepository;
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffDocuments addStaffDocument(StaffDocuments staffDocument, String staffId) {
        Staff staff = staffRepository.findById(staffId).get();
        List<StaffDocuments> list = staff.getStaffDocuments();
        list.add(staffDocumentsRepository.save(staffDocument));
        staff.setStaffDocuments(list);
        staffRepository.save(staff);
        return null;
    }

    @Override
    public StaffDocuments updateStaffDocuments(String staffDocumentsId, StaffDocuments staffDocuments) {
        return null;
    }

    @Override
    public void deleteStaffDocuments(String staffDocumentsId) {
        staffDocumentsRepository.deleteById(staffDocumentsId);
    }

    @Override
    public List<StaffDocuments> getAllStaffDocuments() {
        return staffDocumentsRepository.findAll();
    }
}
