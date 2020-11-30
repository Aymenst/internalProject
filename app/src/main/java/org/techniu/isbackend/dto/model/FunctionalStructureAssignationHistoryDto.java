package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.techniu.isbackend.entity.FunctionalStructureLevel;
import org.techniu.isbackend.entity.Staff;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FunctionalStructureAssignationHistoryDto {

    private String functionalStructureAssignationHistoryId;
    private String startDate;
    private String endDate;
    private String staffId;
    private String staffName;
    private String levelId;
    private String levelName;
    private String levelType;
}
