package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ContactByOperationUpdateRequest {
    private String contactByOperationId;
    private String contactsType;
    private List<String> mandatoryAttributes;
}
