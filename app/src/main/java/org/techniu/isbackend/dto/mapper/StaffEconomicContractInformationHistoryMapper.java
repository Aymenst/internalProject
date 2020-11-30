package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.dto.model.StaffEconomicContractInformationHistoryDto;
import org.techniu.isbackend.entity.StaffEconomicContractInformationHistory;

@Mapper(componentModel = "spring")
public interface StaffEconomicContractInformationHistoryMapper {
    /**
     * Map dto to model
     *
     * @param staffEconomicContractInformationHistoryDto staffEconomicContractInformationHistoryDto
     * @return StaffEconomicContractInformationHistory
     */
    @Mapping(source = "staffEconomicContractInformationHistoryId", target="_id")
    //@Mapping(target = "company", ignore=true)
    //@Mapping(target = "level", ignore=true)
    StaffEconomicContractInformationHistory dtoToModel(StaffEconomicContractInformationHistoryDto staffEconomicContractInformationHistoryDto);


    /**
     * Map staffEconomicContractInformationHistory to staffEconomicContractInformationHistoryDo
     *
     * @param staffEconomicContractInformationHistory staffEconomicContractInformationHistory
     * @return StaffEconomicContractInformationHistoryContractDto
     */
    @Mapping(source = "_id", target="staffEconomicContractInformationHistoryId")
    StaffEconomicContractInformationHistoryDto modelToDto(StaffEconomicContractInformationHistory staffEconomicContractInformationHistory);
}
