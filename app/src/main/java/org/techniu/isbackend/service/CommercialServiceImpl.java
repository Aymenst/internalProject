package org.techniu.isbackend.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.entity.Commercial;
import org.techniu.isbackend.repository.CommercialRepository;

import java.util.List;
@Service
@Transactional
public class CommercialServiceImpl implements CommercialService {
    private CommercialRepository commercialRepository;
    CommercialServiceImpl(CommercialRepository commercialRepository){
        this.commercialRepository = commercialRepository;
    }
    @Override
    public Commercial saveCommercial(Commercial commercial) {
        return commercialRepository.save(commercial);
    }

    @Override
    public Commercial updateCommercial(String commercialId, Commercial commercial) {
        return commercialRepository.findById(commercialId).map(commercial1 -> {
            commercial.setCommercialId(commercial1.getCommercialId());
            return commercialRepository.save(commercial);
        }).orElseThrow(() -> new ExceptionMessage("Cannot update commercial"));
    }

    @Override
    public ResponseEntity<?> deleteCommercial(String commercialId) {
        return null;
    }

    @Override
    public List<Commercial> getAllCommercial() {
        return commercialRepository.findAll();
    }
}
