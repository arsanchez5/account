package com.banquito.core.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.account.controller.dto.DebitCardDTO;
import com.banquito.core.account.service.DebitCardService;

import java.util.List;

@RestController
@RequestMapping(path ="/debit-cards")
public class DebitCardController {

    private final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<DebitCardDTO>> getDebitCardsByClientId(@PathVariable Integer clientId) {
        try {
            List<DebitCardDTO> debitCardDTOs = debitCardService.getDebitCardsByClientId(clientId);
            return ResponseEntity.ok(debitCardDTOs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<DebitCardDTO>> getDebitCardsByAccountId(@PathVariable Integer accountId) {
        try {
            List<DebitCardDTO> debitCardDTOs = debitCardService.getDebitCardsByAccountId(accountId);
            return ResponseEntity.ok(debitCardDTOs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/card-number/{cardNumber}")
    public ResponseEntity<DebitCardDTO> getDebitCardByCardNumber(@PathVariable String cardNumber) {
        try {
            DebitCardDTO debitCardDTO = debitCardService.findByCardNumber(cardNumber);
            return ResponseEntity.ok(debitCardDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
