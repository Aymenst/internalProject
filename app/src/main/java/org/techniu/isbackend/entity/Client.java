package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(value = "Client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id
    private String _id;
    private String code;
    private String logo;
    private String name;
    private String type;
    @DBRef
    private Staff responsibleCommercial;
    @DBRef
    private Staff assistantCommercial;
    private String multinational = "No";
    private String isActive = "Yes";
    private String phone;
    private String email;
    @DBRef
    private Address address;
}
