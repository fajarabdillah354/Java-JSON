package fajar.belajar.JSON;

import jakarta.validation.constraints.NotNull;

public class Person {

    @NotNull(message = "firstname cannot null")
    private String firstName;

    @NotNull
    private String email;

    @NotNull
    private int balance;

    public Person(String firstName, String email, int balance) {
        this.firstName = firstName;
        this.email = email;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
