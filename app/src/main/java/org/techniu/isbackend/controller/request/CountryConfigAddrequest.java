package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

import java.util.Date;

import static org.techniu.isbackend.exception.ValidationConstants.COMMERCIALOPERATIONSTATUS_NAME_NOT_BLANK;
import static org.techniu.isbackend.exception.ValidationConstants.COMMERCIALOPERATIONSTATUS_PERCENTAGE_NOT_BLANK;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CountryConfigAddrequest {
    private String countryConfigId;
    private Date startDate;
    private Date endDate;
    private String countryId;
    private String leader;
}
