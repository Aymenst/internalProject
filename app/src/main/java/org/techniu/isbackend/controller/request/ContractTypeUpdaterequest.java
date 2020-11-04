package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContractTypeUpdaterequest {

    private String contractTypeId;
    private String code;
    private String name;
    private String description;
    private String stateId;

}
