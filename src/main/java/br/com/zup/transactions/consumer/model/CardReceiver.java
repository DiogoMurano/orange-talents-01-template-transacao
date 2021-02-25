package br.com.zup.transactions.consumer.model;

import br.com.zup.transactions.model.Card;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CardReceiver {

    @JsonProperty(required = true)
    private UUID id;

    @JsonProperty(required = true)
    private String email;

    public CardReceiver() {
    }

    public Card toModel() {
        return new Card(id, email);
    }
}
