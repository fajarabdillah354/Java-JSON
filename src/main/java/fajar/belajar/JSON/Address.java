package fajar.belajar.JSON;

import jakarta.validation.constraints.NotNull;

public class Address {

    @NotNull
    private String city;


    @NotNull
    private String street;

    @NotNull
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
