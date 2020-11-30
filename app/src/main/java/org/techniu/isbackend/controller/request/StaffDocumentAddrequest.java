package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class StaffDocumentAddrequest {

    private String staffId;

    private String name;
    private String number;
    private String expeditionDate;
    private String expirationDate;
    private String docExtension;
}
