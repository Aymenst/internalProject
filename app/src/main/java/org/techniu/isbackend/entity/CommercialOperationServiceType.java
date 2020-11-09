package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(value = "CommercialOperationServiceType")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommercialOperationServiceType{
    @Id
    private String CommercialOperationServiceTypeId;
    @DBRef
    private CommercialOperation commercialOperation;
    @DBRef
    private ServiceType serviceType;
}
