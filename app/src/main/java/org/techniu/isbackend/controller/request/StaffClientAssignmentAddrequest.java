package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StaffClientAssignmentAddrequest {
    private Date startDate;
    private Date endDate;
    private String typeStaff;
    private List<String> clientIds;
    private String  staffId;
}
