package org.techniu.isbackend.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StaffAddrequest {
    private String staffId;
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
    //city
    private String cityId;
    //adress
    private String addressName;
    private String postCode;
    //company
    private String companyId;
    //level
    private String levelId;
}
