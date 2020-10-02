package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Document(value = "FunctionalStructureLevelConfig")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionalStructureLevelConfig implements Serializable {
    @Id
    private String levelConfigId;
    private String level1;
    private String level2;
    private String level3;
}