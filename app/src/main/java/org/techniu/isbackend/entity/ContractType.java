package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "ContractType")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractType implements Serializable {

    @Id
    private String contractTypeId;
    private String code;
    private String name;
    private String description;

    @DBRef
    private StateCountry state;

}
