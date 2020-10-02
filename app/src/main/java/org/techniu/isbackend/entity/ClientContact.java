package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "ClientContact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientContact implements Serializable {

    @Id
    private String clientContactId;
    private String name;
    private String fatherName;
    private String motherName;
    private String department;
    private String position;
    private String companyEmail;
    private String companyPhone;
    private String companyMobilePhone;
    private String companyAddress;
    private String personalEmail;
    private String personalPhone;
    private String personalMobilePhone;
    private String skype;
    @DBRef
    private Client client;
}
