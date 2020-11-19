package org.techniu.isbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document(value = "Bill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    @Id
    private String _id;
    @NotNull
    private String code;
    private String purchaseOrderNumber;
    private double totalEuro;
    private double totalLocal;
    private double valueIVALocal;
    private double valueIVAEuro;
    private double totalAmountEuro;
    private double totalAmountLocal;

    private List<String> desc;
    private List<String> descTotalUSD;
    private List<String> nbrConcepts;

    private Date billingDate;
    private Date paymentDay;
    private Date paymentDate;
    private Date reelPaymentDay;

    private int paymentsBDDay;
    private int reelPaymentDays;
    private boolean paymentDone;

    private Date creationDate;
    private Date modificationDate;

    @DBRef
    private Client client;

    @DBRef
    private Client clientSigned;

    @DBRef
    private CommercialOperation commercialOperation;

    @DBRef
    private FinancialCompany financialCompany;

    @DBRef
    private Currency currency;

    @DBRef
    private Iva iva;

    @DBRef
    private FinancialContract financialContract;
}

