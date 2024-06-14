package com.banquito.core.account.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.account.model.AccountTransaction;
import com.banquito.core.account.service.AccountTransactionService;

@RestController
@RequestMapping("/account-transactions")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;

    public AccountTransactionController(AccountTransactionService accountTransactionService) {
        this.accountTransactionService = accountTransactionService;
    }

    @GetMapping
    public ResponseEntity<List<AccountTransaction>> getAllAccountTransactions() {
        try {
            List<AccountTransaction> transactions = accountTransactionService.obtainAllAccountTransactions();
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountTransaction> getAccountTransactionById(@PathVariable Integer id) {
        try {
            Optional<AccountTransaction> transactionOpt = accountTransactionService.getAccountTransactionById(id);
            return transactionOpt.map(transaction -> new ResponseEntity<>(transaction, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by-type")
    public ResponseEntity<AccountTransaction> getTransactionByType(@RequestParam String transactionType) {
        try {
            AccountTransaction transaction = accountTransactionService.obtainTransactionType(transactionType);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/by-state")
    public ResponseEntity<List<AccountTransaction>> getTransactionsByState(@RequestParam String state) {
        try {
            List<AccountTransaction> transactions = accountTransactionService.findByState(state);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
