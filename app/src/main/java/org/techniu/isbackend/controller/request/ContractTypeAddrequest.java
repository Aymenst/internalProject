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
public class ContractTypeAddrequest {

    @NotBlank(message = CONTRACTTYPE_CODE_NOT_BLANK)
    private String code;
    @NotBlank(message = CONTRACTTYPE_NAME_NOT_BLANK)
    private String name;
    private String description;
    private String stateId;

}
