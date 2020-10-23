package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

import static org.techniu.isbackend.exception.ValidationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SectorCompanyAddrequest {
    // sector 1
    private String firstSectorName;
    private String firstSectorDescription;
    // sector 2
    private String secondSectorName;
    private String secondSectorDescription;
    // sector 3
    private String thirdSectorName;
    private String thirdSectorDescription;
}
