package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import static org.techniu.isbackend.exception.ValidationConstants.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommercialOperationStatusAddrequest {
    private String commercialOperationStatusId;
    @NotBlank(message = COMMERCIALOPERATIONSTATUS_NAME_NOT_BLANK)
    private String name;
    private String percentage;
    private String description;
}
