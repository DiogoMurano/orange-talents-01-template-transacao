package br.com.zup.transactions.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Establishment {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cidade")
    private String city;

    @JsonProperty("endereco")
    private String address;

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

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

    @Override
    public String toString() {
        return "Establishment{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
