package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

import static org.techniu.isbackend.exception.ValidationConstants.COMMERCIALOPERATIONSTATUS_CODE_NOT_BLANK;
import static org.techniu.isbackend.exception.ValidationConstants.COMMERCIALOPERATIONSTATUS_NAME_NOT_BLANK;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CivilityTitleUpdateRequest {
    private String civilityTitleId;
    @NotBlank(message = COMMERCIALOPERATIONSTATUS_NAME_NOT_BLANK)
    private String name;
    @NotBlank(message = COMMERCIALOPERATIONSTATUS_CODE_NOT_BLANK)
    private String code;
}
