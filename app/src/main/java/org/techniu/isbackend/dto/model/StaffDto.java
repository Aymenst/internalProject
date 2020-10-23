package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

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
    private String cityName;
    //state
    private String stateName;
    //country
    private String countryName;
    //adress
    private String addressName;
    private String postCode;
    //company
    private String companyId;
    //level
    private String levelId;
}
