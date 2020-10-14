package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.Commercial;

import java.util.List;

public interface CommercialService {
    Commercial saveCommercial(Commercial commercial);
    Commercial updateCommercial(String commercialId, Commercial commercial);
    ResponseEntity<?> deleteCommercial(String commercialId);
    List<Commercial> getAllCommercial();
}
