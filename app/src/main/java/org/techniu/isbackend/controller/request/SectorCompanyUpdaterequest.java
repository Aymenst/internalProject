package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SectorCompanyUpdaterequest {
    // sector 1
    private String firstSectorId;
    private String firstSectorName;
    private String firstSectorDescription;
    // sector 2
    private String secondSectorId;
    private String secondSectorName;
    private String secondSectorDescription;
    // sector 3
    private String thirdSectorId;
    private String thirdSectorName;
    private String thirdSectorDescription;
}
