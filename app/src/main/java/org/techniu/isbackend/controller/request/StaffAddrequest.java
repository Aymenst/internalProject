package org.techniu.isbackend.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StaffAddrequest {
    // *** general information *** //
    //
    private String photo;
    // personal info
    private String firstName;
    private String fatherFamilyName;
    private String motherFamilyName;
    private String birthday;
    private String birthCountry;
    private String isLeader;
    // contact info
    private String personalPhone;
    private String personalEmail;
    private String companyPhone;
    private String companyMobilePhone;
    private String companyEmail;
    private String skype;
    private String emergencyContactName;
    private String emergencyContactPhone;
    // Address
    private String cityId;
    private String fullAddress;
    private String postCode;
    // *** documentation *** //
    // id card
    private String idCardNumber;
    private String idCardName= "Id Card";
    private String idCardExpeditionDate;
    private String idCardExpirationDate;
    private String idCardDocExtension;
    // passport
    private String passportNumber;
    private String passportName= "Passport";
    private String passportExpeditionDate;
    private String passportExpirationDate;
    private String passportDocExtension;
    // professional id card
    private String professionalIdCardNumber;
    private String professionalName= "Professional Id Card";
    private String professionalIdCardExpeditionDate;
    private String professionalIdCardExpirationDate;
    private String professionalIdCardDocExtension;
    // Health National Security
    private String hnsNumber;
    private String hnsName= "Health National Security";
    private String hnsExpeditionDate;
    private String hnsExpirationDate;
    private String hnsDocExtension;
    // *** staff contract *** //
    private String companyId;
    private String associateOffice;
    private String  hiringCountry;
    private String townContract;
    private String personalNumber;
    private String highDate;
    private String lowDate;
    private String registrationDate;
    private String preContractDate;
    private String contractTypeId;
    private String legalCategoryTypeId;
    // *** staff economic contract ***//
    private String contractSalary;
    private String companyContractCost;
    private String expenses;
    private String companyExpensesCost;
    private String objectives;
    private String companyObjectivesCost;
    private String totalCompanyCost;
    private String contractSalaryDateGoing;
    private String contractSalaryDateOut;
    private String companyContractCostDateGoing;
    private String companyContractCostDateOut;
    private String expensesDateGoing;
    private String expensesDateOut;
    private String companyExpensesCostDateGoing;
    private String companyExpensesCostDateOut;
    private String objectivesDateGoing;
    private String objectivesDateOut;
    private String companyObjectivesCostDateGoing;
    private String companyObjectivesCostDateOut;
    private String totalCompanyCostDateGoing;
    private String totalCompanyCostDateOut;
    // Created at
    private String createdAt;

}
