package br.com.zup.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction implements Serializable {

    @JsonProperty
    private UUID id;

    @JsonProperty("valor")
    private BigDecimal value;

    @JsonProperty("estabelecimento")
    private Establishment establishment;

    @JsonProperty("cartao")
    private Card card;

    @JsonProperty("efetivadaEm")
    private LocalDateTime activateAt;

    public Transaction(UUID id, BigDecimal value, Establishment establishment, Card card, LocalDateTime activateAt) {
        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.activateAt = activateAt;
    }

    public Transaction() {
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public LocalDateTime getActivateAt() {
        return activateAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", value=" + value +
                ", establishment=" + establishment.toString() +
                ", card=" + card.toString() +
                ", activateAt=" + activateAt +
                '}';
    }
}
