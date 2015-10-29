package fr.altherac.kata;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    private final Operations operations = new Operations();

    public void deposit(Amount amount, LocalDate date) {
        operations.add(new Deposit(amount, date));
        balance = balance.add(amount.getValue());
    }

    public void withdraw(Amount amount, LocalDate date) {
        operations.add(new Withdrawal(amount, date));
        balance = balance.subtract(amount.getValue());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Operations getOperations() {
        return operations;
    }
}
