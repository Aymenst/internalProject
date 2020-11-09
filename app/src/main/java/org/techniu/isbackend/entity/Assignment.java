package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Document()
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain=true)
@Builder
public class Assignment{
    @Id
    private String _id;
    private Date startDate;
    private Date endDate;
    private String typeStaff;
    @DBRef
    private Client client;
    @DBRef
    private Staff staff;
}
