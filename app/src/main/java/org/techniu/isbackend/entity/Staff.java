package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import java.io.Serializable;
import java.util.List;


@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain=true)
@Document(value = "Staff")
@Builder
public class Staff {
    @Id
    private String _id;
    private String name;
    private String fatherFamilyname;
    private String motherFamilyname;
    private String personalPhone;
    private String personalEmail;
    private String companyPhone;
    private String companyMobilePhone;
    private String companyEmail;
    private String birthday;
    private String birthCountry;
    private String residenceCountry;
    private String emergencyContactName;
    private String emergencyContactPhone;
    private String photo;
    private String skype;

    @DBRef
    private Address address;

    @DBRef
    private Company company;

    @DBRef
    private FunctionalStructureLevel level;

    @DBRef
    private List<Identificator> identificators;
}
