package com.banquito.core.account.service;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.DebitCard;
import com.banquito.core.account.repository.DebitCardRepository;

@Service
public class DebitCardService {

    private DebitCardRepository debitCardRepository;

    public DebitCardService(DebitCardRepository debitCardRepository) {
        this.debitCardRepository = debitCardRepository;
    }

    public DebitCard findByCardNumber(String cardNumber) {
        try {
            return debitCardRepository.findByCardNumber(cardNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la tarjeta de débito por número de tarjeta", e);
        }
    }

}
