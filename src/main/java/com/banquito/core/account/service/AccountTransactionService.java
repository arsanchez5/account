package com.banquito.core.account.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.core.account.model.AccountTransaction;
import com.banquito.core.account.repository.AccountTransactionRepository;
import com.banquito.core.account.util.mapper.AccountTransactionMapper;
import com.banquito.core.account.controller.dto.AccountTransactionDTO;

@Service
public class AccountTransactionService {

    private final AccountTransactionRepository accountTransactionRepository;
    private final AccountTransactionMapper accountTransactionMapper;

    public AccountTransactionService(AccountTransactionRepository accountTransactionRepository, AccountTransactionMapper accountTransactionMapper) {
        this.accountTransactionRepository = accountTransactionRepository;
        this.accountTransactionMapper = accountTransactionMapper;
    }

    @Transactional(Transactional.TxType.NEVER)
    public AccountTransaction getTransactionsByAccountId(Integer accountId) {
      Optional<AccountTransaction> transOpt = this.accountTransactionRepository.findAllById(id);
      if(transOpt.isPresent()){
        return transOpt.get();
      } else{
        throw new RuntimeException("No existe la transaccion con id:"+ id);
      }
    }

    public List<AccountTransaction> getTransactionsByTransactionType(String transactionType) {
        return this.accountTransactionRepository.findByTransactionType(transactionType);
    }

    public List<AccountTransaction> getTransactionsByState(String state) {
        return this.accountTransactionRepository.findByState(state);
    }

    @Transactional
    public AccountTransactionDTO createTransaction(AccountTransactionDTO dto) {
        validateTransactionType(dto.getTransactionType());
        validateTransactionState(dto.getState());

        try {
            AccountTransaction accountTransaction = accountTransactionMapper.toEntity(dto);
            accountTransaction.setUniqueKey(DigestUtils.md5Hex(dto.toString()));
            Date currentDate = new Date();
            accountTransaction.setCreationDate(currentDate);
            accountTransaction.setBookingDate(currentDate);
            accountTransaction.setValueDate(currentDate);
            AccountTransaction transactionCreated = accountTransactionRepository.save(accountTransaction);
            return accountTransactionMapper.toDTO(transactionCreated);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear transaccion", e);
        }
    }

    private void validateTransactionType(String transactionType) {
        if (!transactionType.equals("DEB") && !transactionType.equals("CRE")) {
            throw new IllegalArgumentException("Tipo de transaccion invalido: " + transactionType);
        }
    }

    private void validateTransactionState(String state) {
        if (!state.equals("POS") && !state.equals("EXE") && !state.equals("REV")) {
            throw new IllegalArgumentException("Estado de transaccion invalido: " + state);
        }
    }
}
