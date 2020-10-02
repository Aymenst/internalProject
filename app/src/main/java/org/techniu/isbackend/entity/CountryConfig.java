package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "CountryConfig")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryConfig implements Serializable {
    @Id
    private String countryConfigId;
    private Date startDate;
    private Date endDate;
    @DBRef
    private Country country;
    @DBRef
    private Staff leader;
}
