package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "CommercialOperationServiceType")
@Data
@AllArgsConstructor
public class CommercialOperationState implements Serializable {
    @Id
    private String CommercialOperationState;
    private String CommercialOperationStateName;
    private String description;
    private CommercialOperationState parent;
}
