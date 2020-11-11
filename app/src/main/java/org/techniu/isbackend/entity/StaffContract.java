package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "StaffContract")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
@Builder
public class StaffContract implements Serializable {

    @Id
    private String _id;
    private String associateOffice;
    private String hiringCountry;
    private String townContract;
    private String personalNumber;
    private String highDate;
    private String lowDate;
    private String registrationDate;
    private String preContractDate;
    private  byte[] internalRulesDoc;
    private  byte[] contractDoc;
    private  byte[] preContractDoc;

    @DBRef
    private FinancialCompany company;

    @DBRef
    ContractType contractType;

    @DBRef
    LegalCategoryType legalCategoryType;

}
