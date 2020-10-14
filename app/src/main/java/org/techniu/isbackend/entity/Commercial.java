package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(value = "Commercial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commercial  implements Serializable {
    @Id
    private String commercialId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String country;
    private String city;
    private String type;
}
