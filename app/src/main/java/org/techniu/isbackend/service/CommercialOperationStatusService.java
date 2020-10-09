package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.CityDto;
import org.techniu.isbackend.dto.model.CommercialOperationStatusDto;
import org.techniu.isbackend.dto.model.StaffDto;
import org.techniu.isbackend.entity.Address;
import org.techniu.isbackend.entity.CommercialOperationStatus;
import org.techniu.isbackend.entity.Staff;

import java.util.List;

public interface CommercialOperationStatusService {
    CommercialOperationStatus save(CommercialOperationStatusDto commercialOperationStatusDto);
    List<CommercialOperationStatusDto> getAll();
    CommercialOperationStatus update(CommercialOperationStatusDto commercialOperationStatusDto);
}
