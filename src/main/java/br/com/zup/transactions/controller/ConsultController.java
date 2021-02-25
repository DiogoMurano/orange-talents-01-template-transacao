package br.com.zup.transactions.controller;

import br.com.zup.transactions.controller.response.TransactionResponse;
import br.com.zup.transactions.model.Card;
import br.com.zup.transactions.model.Transaction;
import br.com.zup.transactions.repository.CardRepository;
import br.com.zup.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/consult")
public class ConsultController {

    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public ConsultController(CardRepository cardRepository, TransactionRepository transactionRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
    }

    @GetMapping("/card/{id}/consult")
    public ResponseEntity<List<TransactionResponse>> consult(@PathVariable UUID externalId) {
        Card card = cardRepository.findByExternalId(externalId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found."));

        List<Transaction> transactions = transactionRepository.findTop10ByCardOrderByActivateAt(card);

        List<TransactionResponse> response = transactions.stream()
                .map(TransactionResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

}
