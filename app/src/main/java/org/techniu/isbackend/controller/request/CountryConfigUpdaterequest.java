package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CountryConfigUpdaterequest {
    private String countryConfigId;
    private Date startDate;
    private Date endDate;
    private String countryId;
    private String leaderId;
}
