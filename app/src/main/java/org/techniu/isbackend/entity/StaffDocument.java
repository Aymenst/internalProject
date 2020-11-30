package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "StaffDocument")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDocument implements Serializable {

    @Id
    private String staffDocumentId;
    private String name;
    private String number;
    private String expeditionDate;
    private String expirationDate;
    private String docExtension;
    private byte[] document;

}
