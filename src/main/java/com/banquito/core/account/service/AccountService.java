package com.banquito.core.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.Account;
import com.banquito.core.account.repository.AccountRepository;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        try {
            return accountRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las cuentas", e);
        }
    }

    public Optional<Account> getAccountById(Integer id) {
        try {
            return accountRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la cuenta con ID: " + id, e);
        }
    }

    
}
