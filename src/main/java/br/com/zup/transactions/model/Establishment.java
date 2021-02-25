package br.com.zup.transactions.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Establishment {

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    @Deprecated
    public Establishment() {
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
