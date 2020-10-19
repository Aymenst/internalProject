package org.techniu.isbackend.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "ContractStatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractStatus implements Serializable {
    @Id
    private String _id;
    private int statusCode;
    private String statusName;
    private String description;
    private Date creationDate;
}
