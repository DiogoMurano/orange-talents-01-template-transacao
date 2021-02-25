package br.com.zup.transactions.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private UUID externalId;

    @NotBlank
    @Email
    private String email;

    public Card(@NotNull UUID externalId, @NotBlank @Email String email) {
        this.externalId = externalId;
        this.email = email;
    }

    @Deprecated
    public Card() {
    }

    public Long getId() {
        return id;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public String getEmail() {
        return email;
    }
}
