package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(value = "Leader")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Leader implements Serializable {
    @Id
    private String leaderId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String country;
    private String city;
    private String function;
    private String color;
}
