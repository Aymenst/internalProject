package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.techniu.isbackend.entity.StaffDocuments;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffContractDto {

    private String staffContractId;
    private String companyId;
    private String companyName;
    private String associateOffice;
    private String hiringCountry;
    private String townContract;
    private String personalNumber;
    private String highDate;
    private String lowDate;
    private String registrationDate;
    private String preContractDate;
    private String contractTypeId;
    private String contractTypeName;
    private String contractTypeStateId;
    private String contractTypeState;
    private String contractTypeCountryId;
    private String contractTypeCountry;
    private String legalCategoryTypeId;
    private String legelCategoryTypeName;
    private  byte[] internalRulesDoc;
    private  byte[] contractDoc;
    private  byte[] preContractDoc;
    private String updatedAt;
}
