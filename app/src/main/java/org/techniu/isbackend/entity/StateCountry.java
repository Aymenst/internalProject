package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(value = "Commercial_State")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateCountry implements Serializable {
    @Id
    private String stateCountryId;
    private String stateCountryName;
    @DBRef
    private Country country;
    @DBRef
    private List<City> cities;
}
