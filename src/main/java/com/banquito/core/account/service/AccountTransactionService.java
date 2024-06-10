package com.banquito.core.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.AccountTransaction;
import com.banquito.core.account.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;

    public AccountTransactionService(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    public List<AccountTransaction> obtainAllAccountTransactions() {
        try {
            return this.accountTransactionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las transacciones", e);
        }
    }

    public Optional<AccountTransaction> getAccountTransactionById(Integer id) {
        try {
            return accountTransactionRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la transacción con ID: " + id, e);
        }
    }

    public AccountTransaction obtainTransactionType(String transactionType) {
        try {
            List<AccountTransaction> transactionTypeList = this.accountTransactionRepository
                    .findByTransactionType(transactionType);
            if (!transactionTypeList.isEmpty()) {
                return transactionTypeList.get(0); // Assuming you only need the first one
            } else {
                throw new RuntimeException("No existe una transacción con tipo: " + transactionType);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar transacciones por tipo", e);
        }
    }

    public List<AccountTransaction> findByState(String state) {
        try {
            return accountTransactionRepository.findByState(state);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar transacciones por estado", e);
        }
    }
}
