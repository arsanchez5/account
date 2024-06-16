package com.banquito.core.account.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.Account;
import com.banquito.core.account.repository.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getById(Integer id) {
        Optional<Account> account = this.accountRepository.findById(id);
        return account.orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }
}
