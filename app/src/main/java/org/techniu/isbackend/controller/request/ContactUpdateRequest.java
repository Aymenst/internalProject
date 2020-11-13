package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContactUpdateRequest {
    private String contactId;
    private String firstName;
    private String fatherFamilyName;
    private String motherFamilyName;
    private String department;
    private String position;
    private String companyFixPhone;
    private String companyMobilePhone;
    private String companyEmail;
    private String personalMobilePhone;
    private String personalEmail;
    private String skype;
    private String photo;
    // company
    private String companyId;
    // address
    private String cityId;
    private String fullAddress;
    private String cityName;
    private String stateName;
    private String countryName;
    private String postCode;
}
