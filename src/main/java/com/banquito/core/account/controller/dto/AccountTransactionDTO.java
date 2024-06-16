package com.banquito.core.account.controller.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountTransactionDTO {
    private Integer id;
    private Integer accountId;
    private String codeChannel;
    private String uniqueKey;
    private String transactionType;
    private String transactionSubtype;
    private String reference;
    private BigDecimal amount;
    private String creditorBankCode;
    private String creditorAccount;
    private String debitorBankCode;
    private String debitorAccount;
    private Date creationDate;
    private Date bookingDate;
    private Date valueDate;
    private String applyTax;
    private String parentTransactionKey;
    private String state;
    private String notes;
}
