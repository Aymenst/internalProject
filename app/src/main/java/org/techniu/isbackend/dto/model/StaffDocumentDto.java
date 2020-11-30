package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.StaffDocument;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaffDocumentDto {

    private String staffDocumentId;
    private String name;
    private String number;
    private String expeditionDate;
    private String expirationDate;
    private String docExtension;
    private byte[] document;

}
