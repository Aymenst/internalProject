package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "CivilityTitle")
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain=true)
@Builder
public class CivilityTitle {
    @Id
    private String _id;
    private String name;
    private String code;
}
