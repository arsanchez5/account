package com.banquito.core.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.core.account.model.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    List<AccountTransaction> findByAccountId(Integer accountId);

    List<AccountTransaction> findByTransactionType(String transactionType);

    List<AccountTransaction> findByState(String state);

}
