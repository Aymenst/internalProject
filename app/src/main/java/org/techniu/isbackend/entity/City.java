package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "Commercial_City")
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain=true)
@Builder
public class City implements Serializable {
    @Id
    private String _id;
    private String cityName;
    @DBRef
    private StateCountry stateCountry;
}
