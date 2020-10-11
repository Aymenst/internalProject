package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

import static org.techniu.isbackend.exception.ValidationConstants.SERVICETYPE_NAME_NOT_BLANK;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ServiceTypeAddrequest {
    private String serviceTypeId;
   @NotBlank(message = SERVICETYPE_NAME_NOT_BLANK)
    private String name;
    private String description;
}
