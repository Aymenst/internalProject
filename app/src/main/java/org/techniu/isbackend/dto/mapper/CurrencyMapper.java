package org.techniu.isbackend.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.techniu.isbackend.controller.request.CurrencyAddrequest;
import org.techniu.isbackend.controller.request.CurrencyUpdaterequest;
import org.techniu.isbackend.dto.model.CurrencyDto;
import org.techniu.isbackend.entity.Currency;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {
    /**
     * Map dto to model
     *
     * @param currencyDto currencyDto
     * @return Currency
     */
    @Mapping(source = "currencyId", target="_id")
    Currency dtoToModel(CurrencyDto currencyDto);

    /**
     * Map Currency to CurrencyDo
     *
     * @param currencyAddrequest currencyAddrequest
     * @return CurrencyDto
     */
    CurrencyDto addRequestToDto(CurrencyAddrequest currencyAddrequest);

    /**
     * Map Currency to CurrencyDo
     *
     * @param currencyUpdaterequest currencyUpdaterequest
     * @return CurrencyDto
     */
    CurrencyDto updateRequestToDto(CurrencyUpdaterequest currencyUpdaterequest);

    /**
     * Map currency to currencyDo
     *
     * @param currency currency
     * @return CurrencyDto
     */
    @Mapping(source = "_id", target="currencyId")
    CurrencyDto modelToDto(Currency currency);
}
