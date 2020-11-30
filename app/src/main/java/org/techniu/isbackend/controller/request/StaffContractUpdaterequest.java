package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StaffContractUpdaterequest {

    private String staffContractId;
    private String companyId;
    private String associateOffice;
    private String hiringCountry;
    private String townContract;
    private String personalNumber;
    private String highDate;
    private String lowDate;
    private String registrationDate;
    private String preContractDate;
    private String contractTypeId;
    private String legalCategoryTypeId;
    private String contractModelId;
    private String updatedAt;


}
