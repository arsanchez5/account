package com.banquito.core.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.account.controller.dto.AccountTransactionDTO;
import com.banquito.core.account.service.AccountTransactionService;
import com.banquito.core.account.util.mapper.AccountTransactionMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account-transactions")
public class AccountTransactionController {

    private final AccountTransactionService accountTransactionService;
    private final AccountTransactionMapper accountTransactionMapper;

    public AccountTransactionController(AccountTransactionService accountTransactionService,
            AccountTransactionMapper accountTransactionMapper) {
        this.accountTransactionService = accountTransactionService;
        this.accountTransactionMapper = accountTransactionMapper;
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<AccountTransactionDTO>> getTransactionsByAccountId(@PathVariable Integer accountId) {
        List<AccountTransactionDTO> transactionDTOs = accountTransactionService.getTransactionsByAccountId(accountId)
                .stream()
                .map(accountTransactionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionDTOs);
    }

    @GetMapping("/type/{transactionType}")
    public ResponseEntity<List<AccountTransactionDTO>> getTransactionsByTransactionType(
            @PathVariable String transactionType) {
        List<AccountTransactionDTO> transactionDTOs = accountTransactionService
                .getTransactionsByTransactionType(transactionType).stream()
                .map(accountTransactionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionDTOs);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<AccountTransactionDTO>> getTransactionsByState(@PathVariable String state) {
        List<AccountTransactionDTO> transactionDTOs = accountTransactionService.getTransactionsByState(state).stream()
                .map(accountTransactionMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transactionDTOs);
    }

    @PostMapping
    public ResponseEntity<AccountTransactionDTO> createTransaction(
            @RequestBody AccountTransactionDTO accountTransactionDTO) {
        try {
            AccountTransactionDTO createdTransactionDTO = accountTransactionService
                    .createTransaction(accountTransactionDTO);
            return new ResponseEntity<>(createdTransactionDTO, HttpStatus.CREATED);
        } catch (RuntimeException rte) {
            rte.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
