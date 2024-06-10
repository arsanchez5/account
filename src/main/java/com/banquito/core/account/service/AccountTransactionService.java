package com.banquito.core.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.AccountTransaction;
import com.banquito.core.account.repository.AccountTransactionRepository;

@Service
public class AccountTransactionService {

    private AccountTransactionRepository accountTransactionRepository;

    public List<AccountTransaction> getAllAccountTransactions() {
        try {
            return accountTransactionRepository.findAll();
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

    public List<AccountTransaction> findByTransactionType(String transactionType) {
        try {
            return accountTransactionRepository.findByTransactionType(transactionType);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar transacciones por tipo de transacción", e);
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

