package com.banquito.core.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.core.account.model.DebitCard;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {

    DebitCard findByCardNumber(String cardNumber);
}
