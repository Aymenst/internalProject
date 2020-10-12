package org.techniu.isbackend.service;

import org.techniu.isbackend.dto.model.StateCountryDto;
import org.techniu.isbackend.entity.StateCountry;

import java.util.List;

public interface StateCountryService {
    List<StateCountryDto> getAllState(String county);
}
