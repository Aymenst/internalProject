package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(value = "FunctionalStructureAssignationHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionalStructureAssignationHistory implements Serializable {
    @Id
    private String _id;
    private String startDate;
    private String endDate;

    @DBRef
    private Staff staff;

    @DBRef
    private FunctionalStructureLevel level;


}
