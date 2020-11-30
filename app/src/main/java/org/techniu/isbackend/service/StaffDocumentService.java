package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StaffDocumentDto;
import org.techniu.isbackend.entity.StaffDocument;

public interface StaffDocumentService {

    void save(StaffDocumentDto staffDocumentDto, String staffId);
    void remove(String staffDocumentId);
}
