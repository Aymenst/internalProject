package org.techniu.isbackend.service;

import org.techniu.isbackend.entity.StaffDocuments;

import java.util.List;

public interface StaffDocumentsService {

    StaffDocuments addStaffDocument(StaffDocuments staffDocument, String staffId);
    StaffDocuments updateStaffDocuments(String staffDocumentsId, StaffDocuments staffDocuments);
    void deleteStaffDocuments(String staffDocumentsId);
    List<StaffDocuments> getAllStaffDocuments();
}
