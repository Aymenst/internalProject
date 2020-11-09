package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

import static org.techniu.isbackend.exception.ValidationConstants.*;
import static org.techniu.isbackend.exception.ValidationConstants.LEGALCATEGORYTYPE_FUNCTIONS_NOT_BLANK;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LegalCategoryTypeUpdaterequest {

    private String legalCategoryTypeId;
    @NotBlank(message = LEGALCATEGORYTYPE_NAME_NOT_BLANK)
    private String name;
    @NotBlank(message = LEGALCATEGORYTYPE_FUNCTIONS_NOT_BLANK)
    private String functions;
}
