package org.techniu.isbackend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.StaffDocuments;
import org.techniu.isbackend.repository.StaffDocumentsRepository;

import java.util.List;

@Service
@Transactional
public class StaffDocumentsServiceImpl implements StaffDocumentsService {

    private StaffDocumentsRepository staffDocumentsRepository;

    StaffDocumentsServiceImpl(StaffDocumentsRepository staffDocumentsRepository) {
        this.staffDocumentsRepository = staffDocumentsRepository;
    }

    @Override
    public StaffDocuments saveStaffDocuments(StaffDocuments staffDocuments) {
        return staffDocumentsRepository.save(staffDocuments);
    }

    @Override
    public StaffDocuments updateStaffDocuments(String staffDocumentsId, StaffDocuments staffDocuments) {
        return null;
    }

    @Override
    public void deleteStaffDocuments(String staffDocumentsId) {
        StaffDocuments staffDocuments = staffDocumentsRepository.findById(staffDocumentsId).get();
        staffDocumentsRepository.delete(staffDocuments);
    }

    @Override
    public List<StaffDocuments> getAllStaffDocuments() {
        return staffDocumentsRepository.findAll();
    }
}
