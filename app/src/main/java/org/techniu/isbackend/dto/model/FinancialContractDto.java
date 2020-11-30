package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.techniu.isbackend.entity.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinancialContractDto {

    @NotNull
    private String financialContractId;
    private String contractTitle;
    private String taxeIdentityNumber;
    private Date signedDate;
    private Date startDate;
    private Date endDate;
    private Date finalReelDate;
    private Date firstDayInsured;
    private Date lastDayInsured;
    private Date purchaseOrderReceiveDate;
    private double contractTradeVolume;
    private double contractTradeVolumeEuro;
    private double conceptTotalAmount;
    private double conceptTotalAmountEuro;
    private double amountInsured;
    private double amountInsuredEuro;
    private double penaltyMaxValue;
    private int penaltyMaxType;
    private int paymentsBDDays;

    private List<String> contractDocumentation;
    private List<String> contractDocDescreption;
    private List<String> insureDocumentation;
    private String purchaseOrderDocumentation;
    private String proposalDocumentation;
    private List<String> proposalDocumentationDuo;

    private List<String> conceptType;
    private List<String> conceptValue;
    private List<String> conceptValueEuro;
    private List<String> conceptValueLocal;

    private List<String> purchaseOrderNumber;

    private List<String> penaltyQuantity;
    private List<String> penaltyValue;
    private List<String> penaltyCost;
    private List<String> penaltyPer;

    private List<String> penaltiesListe;
    private List<String> purchaseOrders;
    private List<String> insureDocumentations;
    private List<String> contractDocumentations;
    private List<String> nbrConcepts;

    @DBRef
    private FinancialCompany financialCompany;

    @DBRef
    private Client client;

    @DBRef
    private CommercialOperation commercialOperation;

    @DBRef
    private ContractStatus contractStatus;

    @DBRef
    private FunctionalStructureLevel functionalStructureLevel;

    @DBRef
    private Address address;

    @DBRef
    private Currency currency;

}
