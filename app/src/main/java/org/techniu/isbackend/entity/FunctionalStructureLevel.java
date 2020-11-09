package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(value = "FunctionalStructureLevel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionalStructureLevel implements Serializable {

    @Id
    private String _id;
    private String name;
    private String description;
    private String type;
    private String isProductionLevel;
    private String isCommercialLevel;

    @DBRef
    private List<FunctionalStructureLevel> childs;

}

