package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static org.techniu.isbackend.exception.ValidationConstants.COMMERCIALOPERATIONSTATUS_NAME_NOT_BLANK;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContractStatusAddrequest {
    // @NotBlank(message = CONTRACTSTATUS_CODE_NOT_BLANK)
    private int statusCode;
    // @NotBlank(message = ContractSTATUS_NAME_NOT_BLANK)
    private String statusName;
    private String contractStatusId;
    private String description;
}
