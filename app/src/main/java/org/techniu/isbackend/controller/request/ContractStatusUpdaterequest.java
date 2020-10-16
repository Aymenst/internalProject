package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContractStatusUpdaterequest {
    // @NotBlank(message = CONTRACTSTATUS_CODE_NOT_BLANK)
    private String contractStatusId;
    private int statusCode;
    // @NotBlank(message = ContractSTATUS_NAME_NOT_BLANK)
    private String statusName;
    private String description;
}
