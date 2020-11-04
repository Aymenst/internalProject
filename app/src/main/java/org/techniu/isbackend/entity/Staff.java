package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(value = "Staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff implements Serializable {
    @Id
    private String staffId;
    private String firstName;
    private String fatherFamilyName;
    private String motherFamilyName;
    private String personalPhone;
    private String personalEmail;
    private String companyPhone;
    private String companyMobilePhone;
    private String companyEmail;
    private String skype;
    private String birthday;
    private String birthCountry;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String photo;
    private String isLeader;

    @DBRef
    private Address address;

    @DBRef
    private FunctionalStructureLevel level;

    @DBRef
    private StaffContract staffContract;

    @DBRef
    private StaffEconomicContractInformation staffEconomicContractInformation;

    @DBRef
    private List<StaffDocuments> staffDocuments;
}
