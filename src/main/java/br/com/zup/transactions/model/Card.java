package br.com.zup.transactions.model;

import com.sun.istack.NotNull;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Embeddable
public class Card {

    @NotNull
    private UUID cardId;

    @NotBlank
    @Email
    private String email;

    public Card(UUID cardId, String email) {
        this.cardId = cardId;
        this.email = email;
    }

    @Deprecated
    public Card() {
    }

    public UUID getCardId() {
        return cardId;
    }

    public String getEmail() {
        return email;
    }
}
