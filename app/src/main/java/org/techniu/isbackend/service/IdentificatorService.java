package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Identificator;

import java.util.List;

public interface IdentificatorService {
    Identificator saveIdentificator(Identificator level);
    ResponseEntity<?> deleteIdentificator(String identificatorId);
    List<Identificator> getAllIdentificators();
}
