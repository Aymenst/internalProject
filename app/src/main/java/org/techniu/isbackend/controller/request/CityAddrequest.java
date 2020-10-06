package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CityAddrequest {
    private String cityId;
    private String cityName;
    // state
    private String stateName;
    // country
    private String countryName;
    private String phonePrefix;
    private String countryCode;
}
