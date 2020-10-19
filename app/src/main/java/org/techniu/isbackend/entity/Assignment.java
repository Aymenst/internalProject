package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Document(value = "Assignment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment implements Serializable {
    @Id
    private String assignmentId;
    private Date startDate;
    private Date endDate;
    private String type;
    @DBRef
    private Client client;
    @DBRef
    private Staff staff;
}
