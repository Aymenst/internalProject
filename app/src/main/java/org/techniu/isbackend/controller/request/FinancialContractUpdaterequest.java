package org.techniu.isbackend.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.techniu.isbackend.entity.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FinancialContractUpdaterequest {
    // @NotBlank(message = IVA_CODE_NOT_BLANK)
    // @NotBlank(message = IVA_NAME_NOT_BLANK)
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

    private FinancialCompany financialCompany;
    private Client client;
    private CommercialOperation commercialOperation;
    private ContractStatus contractStatus;
    private FunctionalStructureLevel functionalStructureLevel;
    private Address address;
    private Currency currency;
}
