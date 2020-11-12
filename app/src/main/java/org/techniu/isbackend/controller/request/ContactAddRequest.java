package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

import static org.techniu.isbackend.exception.ValidationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContactAddRequest {
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
    private String postCode;
}
