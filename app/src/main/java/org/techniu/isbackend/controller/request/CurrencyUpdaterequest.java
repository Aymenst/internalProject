package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CurrencyUpdaterequest {
    // @NotBlank(message = CONTRACTSTATUS_CODE_NOT_BLANK)
    
    private String currencyId;
    private String currencyCode;
    private String currencyName;
    private int year;
    private int month;
    private String changeFactor;
}
