package br.com.zup.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Card {

    @JsonProperty
    private UUID id;

    @JsonProperty
    private String email;

    public Card(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public Card() {
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
