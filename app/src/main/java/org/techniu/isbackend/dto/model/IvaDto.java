package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IvaDto {

    @NotNull
    private String ivaId;
    @NotNull
    private int ivaCode;
    @NotNull
    private String country;
    private String state;
    @NotNull
    private int value;
    @NotNull
    private boolean electronicInvoice;
    @NotNull
    private Date startingDate;
    private Date endingDate;

}
