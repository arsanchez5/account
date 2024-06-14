package com.banquito.core.account.controller.dto.Builder;

import com.banquito.core.account.controller.dto.AccountDTO;
import com.banquito.core.account.model.Account;

public class AccountBuilder {
    public static AccountDTO toDto(Account account) {
        AccountDTO dto = AccountDTO.builder()
                .id(account.getId())
                .codeProductType(account.getCodeProductType())
                .codeProduct(account.getCodeProduct())
                .clientId(account.getClientId())
                .codeUniqueAccount(account.getCodeUniqueAccount())
                .codeInternalAccount(account.getCodeInternalAccount())
                .codeInternationalAccount(account.getCodeInternationalAccount())
                .state(account.getState())
                .creationDate(account.getCreationDate())
                .activationDate(account.getActivationDate())
                .lastModifiedDate(account.getLastModifiedDate())
                .currentBalance(account.getCurrentBalance())
                .availableBalance(account.getAvailableBalance())
                .blockedBalance(account.getBlockedBalance())
                .closeDate(account.getCloseDate())
                .build();
        return dto;
    }

    public static Account toEntity(AccountDTO dto) {
        Account account = new Account();
        account.setId(dto.getId());
        account.setCodeProductType(dto.getCodeProductType());
        account.setCodeProduct(dto.getCodeProduct());
        account.setClientId(dto.getClientId());
        account.setCodeUniqueAccount(dto.getCodeUniqueAccount());
        account.setCodeInternalAccount(dto.getCodeInternalAccount());
        account.setCodeInternationalAccount(dto.getCodeInternationalAccount());
        account.setState(dto.getState());
        account.setCreationDate(dto.getCreationDate());
        account.setActivationDate(dto.getActivationDate());
        account.setLastModifiedDate(dto.getLastModifiedDate());
        account.setCurrentBalance(dto.getCurrentBalance());
        account.setAvailableBalance(dto.getAvailableBalance());
        account.setBlockedBalance(dto.getBlockedBalance());
        account.setCloseDate(dto.getCloseDate());
        return account;
    }
}
