package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Identificator")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identificator {

    @Id
    private String identificatorId;
    private String idType;
    private String idCountry;
    private String idNumber;
    private String idExpeditionDate;
    private String idExpiryDate;
}
