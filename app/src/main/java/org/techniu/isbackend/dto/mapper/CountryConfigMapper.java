package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CountryConfigAddrequest;
import org.techniu.isbackend.controller.request.CountryConfigUpdaterequest;
import org.techniu.isbackend.dto.model.CountryConfigDto;
import org.techniu.isbackend.entity.CountryConfig;

@Mapper(componentModel = "spring")
public interface CountryConfigMapper {
    /**
     * Map dto to model
     *
     * @param countryConfigDto countryConfigDto
     * @return CountryConfig
     */
    @Mapping(source = "countryConfigId", target="countryConfigId")
    @Mapping(target = "country", ignore=true)
    @Mapping(target = "leader", ignore=true)
    CountryConfig dtoToModel(CountryConfigDto countryConfigDto);

    /**
     * Map CountryConfig to CountryConfigDo
     *
     * @param countryConfigAddrequest countryConfigAddrequest
     * @return CountryConfigDto
     */
    CountryConfigDto addRequestToDto(CountryConfigAddrequest countryConfigAddrequest);

    /**
     * Map CountryConfig to CountryConfigDo
     *
     * @param countryConfigUpdaterequest countryConfigUpdaterequest
     * @return CountryConfigDto
     */
    CountryConfigDto updateRequestToDto(CountryConfigUpdaterequest countryConfigUpdaterequest);

    /**
     * Map countryConfig to countryConfigDo
     *
     * @param countryConfig countryConfig
     * @return CountryConfigDto
     */
    @Mapping(source = "countryConfigId", target="countryConfigId")
    @Mapping(target = "countryId", ignore=true)
    @Mapping(target = "leader", ignore=true)
    CountryConfigDto modelToDto(CountryConfig countryConfig);
}
