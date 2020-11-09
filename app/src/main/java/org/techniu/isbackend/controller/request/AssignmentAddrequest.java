package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.techniu.isbackend.entity.Client;
import org.techniu.isbackend.entity.Staff;

import javax.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

import static org.techniu.isbackend.exception.ValidationConstants.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AssignmentAddrequest {
    private Date startDate;
    private Date endDate;
    private String typeStaff;
    private List<String> clientIds;
    private String  staffId;
}
