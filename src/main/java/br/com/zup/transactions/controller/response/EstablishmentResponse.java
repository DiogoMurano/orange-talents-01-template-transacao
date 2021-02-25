package br.com.zup.transactions.controller.response;

import br.com.zup.transactions.model.Establishment;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentResponse {

    @JsonProperty
    private final String name;

    @JsonProperty
    private final String city;

    @JsonProperty
    private final String address;

    public EstablishmentResponse(Establishment establishment) {
        this.name = establishment.getName();
        this.city = establishment.getCity();
        this.address = establishment.getAddress();
    }
}
