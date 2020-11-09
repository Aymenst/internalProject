package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(value = "StaffEconomicContractInformationHistory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffEconomicContractInformationHistory implements Serializable {
    @Id
    private String staffEconomicContractInformationHistoryId;
    private StaffEconomicContractInformation staffEconomicContractInformationHistory;

    @DBRef
    private StaffEconomicContractInformation staffEconomicContractInformation;
}
