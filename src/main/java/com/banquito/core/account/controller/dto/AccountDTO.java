package com.banquito.core.account.controller.dto;

import java.math.BigDecimal;
import java.security.Timestamp;


import lombok.Builder;

import lombok.Value;

@Value
@Builder
public class AccountDTO {
    private Integer id;
    private String codeProductType;
    private String codeProduct;
    private Integer clientId;
    private String codeUniqueAccount;
    private String codeInternalAccount;
    private String codeInternationalAccount;
    private String state;
    private Timestamp creationDate;
    private Timestamp activationDate;
    private Timestamp lastModifiedDate;
    private BigDecimal currentBalance;
    private BigDecimal availableBalance;
    private BigDecimal blockedBalance;
    private Timestamp closeDate;
}
