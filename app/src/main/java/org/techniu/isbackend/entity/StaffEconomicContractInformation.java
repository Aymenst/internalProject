package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(value = "StaffEconomicContractInformation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffEconomicContractInformation implements Serializable, Cloneable {

    @Id
    private String staffEconomicContractInformationId;
    private String contractSalary;
    private String companyContractCost;
    private String expenses;
    private String companyExpensesCost;
    private String objectives;
    private String companyObjectivesCost;
    private String totalCompanyCost;
    private String contractSalaryDateGoing;
    private String contractSalaryDateOut;
    private String companyContractCostDateGoing;
    private String companyContractCostDateOut;
    private String expensesDateGoing;
    private String expensesDateOut;
    private String companyExpensesCostDateGoing;
    private String companyExpensesCostDateOut;
    private String objectivesDateGoing;
    private String objectivesDateOut;
    private String companyObjectivesCostDateGoing;
    private String companyObjectivesCostDateOut;
    private String totalCompanyCostDateGoing;
    private String totalCompanyCostDateOut;
    private Date createdAt;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
