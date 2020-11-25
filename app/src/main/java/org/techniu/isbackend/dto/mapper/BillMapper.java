package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.BillAddrequest;
import org.techniu.isbackend.controller.request.BillUpdaterequest;
import org.techniu.isbackend.dto.model.BillDto;
import org.techniu.isbackend.entity.Bill;

@Mapper(componentModel = "spring")
public interface BillMapper {
    /**
     * Map dto to model
     *
     * @param billDto billDto
     * @return Bill
     */
    @Mapping(source = "billId", target="_id")
    Bill dtoToModel(BillDto billDto);

    /**
     * Map Bill to BillDo
     *
     * @param billAddrequest billAddrequest
     * @return BillDto
     */
    BillDto addRequestToDto(BillAddrequest billAddrequest);

    /**
     * Map Bill to BillDo
     *
     * @param billUpdaterequest billUpdaterequest
     * @return BillDto
     */
    BillDto updateRequestToDto(BillUpdaterequest billUpdaterequest);

    /**
     * Map bill to billDo
     *
     * @param bill bill
     * @return BillDto
     */
    @Mapping(source = "_id", target="billId")
    BillDto modelToDto(Bill bill);
}
