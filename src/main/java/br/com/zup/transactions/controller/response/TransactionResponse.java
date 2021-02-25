package br.com.zup.transactions.controller.response;

import br.com.zup.transactions.model.Transaction;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionResponse {

    @JsonProperty
    private final UUID externalId;

    @JsonProperty
    private final BigDecimal value;

    @JsonProperty
    private final EstablishmentResponse establishment;

    @JsonProperty
    private final LocalDateTime activateAt;

    public TransactionResponse(Transaction transaction) {
        this.externalId = transaction.getExternalId();
        this.value = transaction.getValue();
        this.establishment = new EstablishmentResponse(transaction.getEstablishment());
        this.activateAt = transaction.getActivateAt();
    }
}
