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
    private String addressName;
    private String postCode;
    // *** documentation *** //
    // id card
    private String idCardNumber;
    private String idCardName= "Id Card";
    private String idCardExpeditionDate;
    private String idCardExpirationDate;
    private MultipartFile idCardPhoto;
    // passport
    private String passportNumber;
    private String passportName= "Passport";
    private String passportExpeditionDate;
    private String passportExpirationDate;
    private MultipartFile passportPhoto;
    // professional id card
    private String professionalIdCardNumber;
    private String professionalName= "Professional Id Card";
    private String professionalIdCardExpeditionDate;
    private String professionalIdCardExpirationDate;
    private MultipartFile professionalIdCardDatePhoto;
    // Health National Security
    private String hnsNumber;
    private String hnsName= "Health National Security";
    private String hnsExpeditionDate;
    private String hnsExpirationDate;
    private MultipartFile hnsPhoto;

}
