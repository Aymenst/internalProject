package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.dto.model.StaffContractHistoryDto;
import org.techniu.isbackend.entity.StaffContractHistory;

@Mapper(componentModel = "spring")
public interface StaffContractHistoryMapper {
    /**
     * Map dto to model
     *
     * @param staffContractHistoryDto staffContractHistoryDto
     * @return StaffContractHistory
     */
    @Mapping(source = "staffContractHistoryId", target="_id")
    //@Mapping(target = "company", ignore=true)
    //@Mapping(target = "level", ignore=true)
    StaffContractHistory dtoToModel(StaffContractHistoryDto staffContractHistoryDto);


    /**
     * Map staffContractHistory to staffContractHistoryDo
     *
     * @param staffContractHistory staffContractHistory
     * @return StaffContractHistoryContractDto
     */
    @Mapping(source = "_id", target="staffContractHistoryId")
    StaffContractHistoryDto modelToDto(StaffContractHistory staffContractHistory);
}
