package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class CommercialOperationStatusUpdaterequest {
    private String commercialOperationStatusId;
    private String name;
    private String percentage;
    private String description;
}
