package com.banquito.core.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.core.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findByCodeUniqueAccount(String codeUniqueAccount);

    List<Account> findByState(String state);

}
