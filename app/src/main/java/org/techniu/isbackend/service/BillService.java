package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.BillDto;
import org.techniu.isbackend.entity.Bill;

import java.util.List;

public interface BillService {

    void saveBill(BillDto billDto);

    List<BillDto> getAllBill();

    Bill getById(String id);

    List<BillDto> updateBill(BillDto billDto, String id);

    List<BillDto> remove(String id);
}
