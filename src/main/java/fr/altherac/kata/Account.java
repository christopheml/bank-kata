package fr.altherac.kata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private BigDecimal balance = BigDecimal.ZERO;

    private final List<Operation> operations = new ArrayList<>();

    public void deposit(Amount amount, LocalDate date) {
        operations.add(new Operation(amount, date));
        balance = balance.add(amount.getValue());
    }

    public void withdraw(Amount amount, LocalDate date) {
        operations.add(new Operation(amount, date));
        balance = balance.subtract(amount.getValue());
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Operation> getOperations() {
        return operations;
    }
}
