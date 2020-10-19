package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "ClientContact")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientContact implements Serializable {

    @Id
    private String ClientContractId;
    private Date signedDate;
    private Date startDate;
    private Date endDate;
    private Date finalReelDate;
    @DBRef
    private Client client;
    private Date creationDate;

}
