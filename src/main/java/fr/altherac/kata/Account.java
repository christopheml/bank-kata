package fr.altherac.kata;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(Amount amount, LocalDate date) {
        balance = balance.add(amount.getValue());
    }

    public void withdraw(Amount amount, LocalDate date) {
        balance = balance.subtract(amount.getValue());
    }

    public BigDecimal getBalance() {
        return balance;
    }

}
