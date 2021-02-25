package br.com.zup.transactions.consumer.model;

import br.com.zup.transactions.model.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentReceiver {

    @JsonProperty(value = "nome", required = true)
    private String name;

    @JsonProperty(value = "cidade", required = true)
    private String city;

    @JsonProperty(value = "endereco", required = true)
    private String address;

    public EstablishmentReceiver() {
    }

    public Establishment toModel() {
        return new Establishment(name, city, address);
    }
}
