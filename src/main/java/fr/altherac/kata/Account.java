package fr.altherac.kata;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    public void deposit(int amount, LocalDate date) {
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    public void withdraw(int amount, LocalDate date) {
        balance = balance.subtract(BigDecimal.valueOf(amount));
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
