package org.techniu.isbackend.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
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
public class BillDto {

    @NotNull
    private String billId;

    @NotNull
    private String code;
    @NotNull
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

    private Date invoiceDate;
    private Date registerDate;
    private Date paymentDate;
    private Date delayDate;
    private Date reelPaymentDay;

    private int paymentsBDDay;
    private int reelPaymentDays;
    private boolean paymentDone;

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
