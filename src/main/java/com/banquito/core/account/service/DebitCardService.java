package com.banquito.core.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banquito.core.account.model.DebitCard;
import com.banquito.core.account.repository.DebitCardRepository;
import com.banquito.core.account.util.mapper.DebitCardMapper;
import com.banquito.core.account.controller.dto.DebitCardDTO;

@Service
public class DebitCardService {

    private final DebitCardRepository debitCardRepository;
    private final DebitCardMapper debitCardMapper;

    public DebitCardService(DebitCardRepository debitCardRepository, DebitCardMapper debitCardMapper) {
        this.debitCardRepository = debitCardRepository;
        this.debitCardMapper = debitCardMapper;
    }

    public DebitCardDTO findByCardNumber(String cardNumber) {
        try {
            DebitCard debitCard = debitCardRepository.findByCardNumber(cardNumber);
            return debitCardMapper.toDTO(debitCard);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la tarjeta de débito por número de tarjeta", e);
        }
    }

    public List<DebitCardDTO> getDebitCardsByClientId(Integer clientId) {
        try {
            List<DebitCard> debitCards = debitCardRepository.findByClientId(clientId);
            return debitCards.stream()
                    .map(debitCardMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar tarjetas de débito por ID de cliente", e);
        }
    }

    public List<DebitCardDTO> getDebitCardsByAccountId(Integer accountId) {
        try {
            List<DebitCard> debitCards = debitCardRepository.findByAccountId(accountId);
            return debitCards.stream()
                    .map(debitCardMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar tarjetas de débito por ID de cuenta", e);
        }
    }

}
