package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "IVA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Iva implements Serializable {

    @Id
    private String _id;
    private int ivaCode;
    private String country;
    private String state;
    private int value;
    private boolean electronicInvoice;
    private Date startingDate;
    private Date endingDate;

    private Date creationDate;
    private Date modificationDate;

}
