package fr.altherac.kata;

import fr.altherac.kata.operation.Deposit;
import fr.altherac.kata.operation.Operations;
import fr.altherac.kata.operation.Withdrawal;

import java.time.LocalDate;

public class Account {

    private Amount balance = Amount.of(0);

    private final Operations operations = new Operations();

    public void deposit(Amount amount, LocalDate date) {
        Deposit deposit = new Deposit(amount, date);
        balance = deposit.applyTo(balance);
        operations.add(deposit);
    }

    public void withdraw(Amount amount, LocalDate date) {
        Withdrawal withdrawal = new Withdrawal(amount, date);
        balance = withdrawal.applyTo(balance);
        operations.add(withdrawal);
    }

    public Amount getBalance() {
        return balance;
    }

    public Operations getOperations() {
        return operations;
    }

}
