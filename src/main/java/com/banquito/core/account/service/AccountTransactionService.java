package com.banquito.core.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.Account;
import com.banquito.core.account.repository.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> obtainAllAccounts() {
        try {
            return this.accountRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las cuentas", e);
        }
    }

}
