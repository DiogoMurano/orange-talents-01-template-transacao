package br.com.zup.transactions.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private UUID externalId;

    @NotNull
    private BigDecimal value;

    @Embedded
    private Establishment establishment;

    @ManyToOne
    private Card card;

    @NotNull
    private LocalDateTime activateAt;

    public Transaction(UUID externalId, BigDecimal value, Establishment establishment, Card card, LocalDateTime activateAt) {
        this.externalId = externalId;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.activateAt = activateAt;
    }

    @Deprecated
    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public UUID getExternalId() {
        return externalId;
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
}
