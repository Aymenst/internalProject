package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    private String contractId;
    private String type;
    private String associateOffice;
    private String hiringCountry;
    private String townContract;
    private String personalNumber;
    private String skypeUser;
    private String highDate;
    private String lowDate;
    private String registrationDate;
    private String precontractDate;
    private String internalRulesDoc;
    private String contractDoc;

    @DBRef
    private Company company;

    @DBRef
    private Client client;

    @DBRef
    private CommercialOperation commercialOperation;

}
