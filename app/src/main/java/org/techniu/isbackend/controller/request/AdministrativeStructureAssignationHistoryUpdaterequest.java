package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdministrativeStructureAssignationHistoryUpdaterequest {

    private String administrativeStructureAssignationHistoryId;
    private String endDate;
    private String staffId;
    private String levelId;


}
