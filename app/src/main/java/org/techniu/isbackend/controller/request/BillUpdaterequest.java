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
public class BillUpdaterequest {

    private String billId;
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

    private Date invoiceDate;
    private Date registerDate;
    private Date paymentDate;
    private Date delayDate;
    private Date reelPaymentDay;

    private int paymentsBDDay;
    private int reelPaymentDays;
    private boolean paymentDone;

    private Client client;
    private Client clientSigned;
    private CommercialOperation commercialOperation;
    private FinancialCompany financialCompany;
    private Currency currency;
    private Iva iva;
    private FinancialContract financialContract;
}
