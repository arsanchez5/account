package com.banquito.core.account.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.account.model.DebitCard;
import com.banquito.core.account.service.DebitCardService;

@RestController
@RequestMapping("/api/debit-cards")
public class DebitCardController {

    private final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<DebitCard> getDebitCardByCardNumber(@PathVariable String cardNumber) {
        try {
            DebitCard debitCard = debitCardService.findByCardNumber(cardNumber);
            if (debitCard != null) {
                return new ResponseEntity<>(debitCard, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
