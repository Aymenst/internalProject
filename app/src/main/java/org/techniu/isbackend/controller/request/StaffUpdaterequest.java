package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StaffUpdaterequest {
    // *** general information *** //
    //
    private String staffId;
    private String photo;
    // personal info
    private String firstName;
    private String fatherFamilyName;
    private String motherFamilyName;
    private String birthday;
    private String birthCountry;
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
    private String addressId;
    private String cityId;
    private String fullAddress;
    private String postCode;

}
