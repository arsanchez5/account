package com.banquito.core.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.account.controller.dto.AccountDTO;
import com.banquito.core.account.model.Account;
import com.banquito.core.account.service.AccountService;
import com.banquito.core.account.util.mapper.AccountMapper;

@RestController
@RequestMapping(path= "/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    public AccountController(AccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getById(@PathVariable Integer id) {
        try {
            Account account = accountService.getById(id);
            AccountDTO accountDTO = accountMapper.toDTO(account);
            return ResponseEntity.ok(accountDTO);
        } catch (Exception e) {
            return  ResponseEntity.notFound().build();
        }
    }
}
