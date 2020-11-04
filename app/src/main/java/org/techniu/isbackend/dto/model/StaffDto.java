package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffDto{
    private String staffId;
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
    private String cityName;
    private String stateName;
    private String countryName;
    private String postCode;
    // *** documentation *** //
    // id card
    private String idCardNumber;
    private String idCardExpeditionDate;
    private String idCardExpirationDate;
    private MultipartFile idCardExpirationDatePhoto;
    // passport
    private String passportNumber;
    private String passportExpeditionDate;
    private String passportExpirationDate;
    private MultipartFile passportExpirationDatePhoto;
    // professional id card
    private String professionalIdCardNumber;
    private String professionalIdCardExpeditionDate;
    private String professionalIdCardExpirationDate;
    private MultipartFile professionalIdCardExpirationDatePhoto;
    // Health National Security
    private String hnsNumber;
    private String hnsExpeditionDate;
    private String hnsExpirationDate;
    private MultipartFile hnsExpirationDatePhoto;

}
