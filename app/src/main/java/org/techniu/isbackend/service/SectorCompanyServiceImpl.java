package org.techniu.isbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.dto.model.SectorCompanyDto;
import org.techniu.isbackend.entity.CommercialOperationStatus;
import org.techniu.isbackend.entity.SectorCompany;

import org.techniu.isbackend.repository.SectorCompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SectorCompanyServiceImpl implements SectorCompanyService {
    private SectorCompanyRepository sectorCompanyRepository;

    SectorCompanyServiceImpl(SectorCompanyRepository sectorCompanyRepository) {
        this.sectorCompanyRepository = sectorCompanyRepository;
    }

    @Override
    public SectorCompany save(SectorCompany sectorCompany) {
       /* SectorCompany secondSector = sectorCompanyRepository.findByName(sectorCompany.getName());
        if(secondSector != null)
        {
            return secondSector;
        }*/
        return sectorCompanyRepository.save(sectorCompany);
    }

    @Override
    public SectorCompany checkIfSectorExist(String sectorCompanyName) {
        SectorCompany secondSector = sectorCompanyRepository.findByName(sectorCompanyName);
        if (secondSector != null) {
            return secondSector;
        }
        return null;
    }

    @Override
    public SectorCompany update(SectorCompany sectorCompany) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(String sectorId) {
        return null;
    }

    @Override
    public List<SectorCompanyDto> getAll() {
        // Get all SectorCompany
        List<SectorCompany> SectorCompanys = sectorCompanyRepository.findAll();
        // Create a list of all actions dto
        ArrayList<SectorCompanyDto> sectorCompanyDtos = new ArrayList<>();

        for (SectorCompany sectorCompany : SectorCompanys) {
            if (sectorCompany.getParent() == null) {
                List<SectorCompany> secondSectors = sectorCompanyRepository.findByParent(sectorCompany);
                System.out.println(secondSectors);
                if (!secondSectors.isEmpty()) {
                    for (SectorCompany secondsectorCompany : secondSectors) {
                        List<SectorCompany> thirdSectors = sectorCompanyRepository.findByParent(secondsectorCompany);
                        if (!thirdSectors.isEmpty()) {
                            for (SectorCompany thirdsectorCompany : thirdSectors) {
                                SectorCompanyDto sectorCompanyDto = new SectorCompanyDto();
                                sectorCompanyDto.setFirstSectorId(sectorCompany.get_id());
                                sectorCompanyDto.setFirstSectorName(sectorCompany.getName());
                                sectorCompanyDto.setFirstSectorDescription(sectorCompany.getDescription());

                                sectorCompanyDto.setSecondSectorId(secondsectorCompany.get_id());
                                sectorCompanyDto.setSecondSectorName(secondsectorCompany.getName());
                                sectorCompanyDto.setSecondSectorDescription(secondsectorCompany.getDescription());

                                sectorCompanyDto.setThirdSectorId(thirdsectorCompany.get_id());
                                sectorCompanyDto.setThirdSectorName(thirdsectorCompany.getName());
                                sectorCompanyDto.setThirdSectorDescription(thirdsectorCompany.getDescription());
                                sectorCompanyDtos.add(sectorCompanyDto);
                            }
                        } else {
                            SectorCompanyDto sectorCompanyDto = new SectorCompanyDto();
                            sectorCompanyDto.setFirstSectorId(sectorCompany.get_id());
                            sectorCompanyDto.setFirstSectorName(sectorCompany.getName());
                            sectorCompanyDto.setFirstSectorDescription(sectorCompany.getDescription());

                            sectorCompanyDto.setSecondSectorId(secondsectorCompany.get_id());
                            sectorCompanyDto.setSecondSectorName(secondsectorCompany.getName());
                            sectorCompanyDto.setSecondSectorDescription(secondsectorCompany.getDescription());
                            sectorCompanyDtos.add(sectorCompanyDto);
                        }
                    }
                } else {
                    SectorCompanyDto sectorCompanyDto = new SectorCompanyDto();
                    sectorCompanyDto.setFirstSectorId(sectorCompany.get_id());
                    sectorCompanyDto.setFirstSectorName(sectorCompany.getName());
                    sectorCompanyDto.setFirstSectorDescription(sectorCompany.getDescription());
                    sectorCompanyDtos.add(sectorCompanyDto);
                }
            }

        }
        return sectorCompanyDtos;
    }

    @Override
    public List<SectorCompanyDto> getAllBysectorByParent(String sectorName) {
        ArrayList<SectorCompanyDto> sectorCompanyDtos = new ArrayList<>();
        List<SectorCompany> SectorCompanys = sectorCompanyRepository.findByParent(sectorCompanyRepository.findByName(sectorName));

        for (SectorCompany sectorCompany : SectorCompanys) {
            SectorCompanyDto sectorCompanyDto = new SectorCompanyDto();
            sectorCompanyDto.setSecondSectorId(sectorCompany.get_id());
            sectorCompanyDto.setSecondSectorName(sectorCompany.getName());
            sectorCompanyDto.setSecondSectorDescription(sectorCompany.getDescription());
           /* List<SectorCompany> thirdSectors = sectorCompanyRepository.findByParent(sectorCompany);
            if (thirdSectors != null) {
                for (SectorCompany thirdsectorCompany : thirdSectors) {
                    sectorCompanyDto.setThirdSectorId(thirdsectorCompany.get_id());
                    sectorCompanyDto.setThirdSectorName(thirdsectorCompany.getName());
                    sectorCompanyDto.setThirdSectorDescription(thirdsectorCompany.getDescription());
                }
            }*/
            sectorCompanyDtos.add(sectorCompanyDto);
        }

        return sectorCompanyDtos;
    }

    @Override
    public List<SectorCompanyDto> getSectorsPrimary() {
        // Get all SectorCompany
        List<SectorCompany> SectorCompanys = sectorCompanyRepository.findAll();
        // Create a list of all actions dto
        ArrayList<SectorCompanyDto> sectorCompanyDtos = new ArrayList<>();

        for (SectorCompany sectorCompany : SectorCompanys) {
            if (sectorCompany.getParent() == null) {
                SectorCompanyDto sectorCompanyDto = new SectorCompanyDto();
                sectorCompanyDto.setFirstSectorId(sectorCompany.get_id());
                sectorCompanyDto.setFirstSectorName(sectorCompany.getName());
                sectorCompanyDto.setFirstSectorDescription(sectorCompany.getDescription());
                sectorCompanyDtos.add(sectorCompanyDto);
            }
        }
           return sectorCompanyDtos;
    }

}
