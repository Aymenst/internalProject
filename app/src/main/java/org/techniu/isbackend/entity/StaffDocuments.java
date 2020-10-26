package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "StaffDocuments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDocuments implements Serializable {

    @Id
    private String staffDocumentsId;
    private String name;
    private String number;
    private String expeditionDate;
    private String expirationDate;
    private String docExtension;
    private byte[] document;

}
