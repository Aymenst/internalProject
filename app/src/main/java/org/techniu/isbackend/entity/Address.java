package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(value = "Address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Address implements Serializable {
    @Id
    private String addressId;
    private String address;
    private String postCode;
    @DBRef
    private City city;
}
