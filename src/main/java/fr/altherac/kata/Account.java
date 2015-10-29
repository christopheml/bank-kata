package fr.altherac.kata;

import fr.altherac.kata.operation.*;

import java.time.LocalDate;

public class Account {

    private final Operations operations = new Operations();

    public void deposit(Amount amount, LocalDate date) {
        operations.add(new Deposit(amount, date));
    }

    public void withdraw(Amount amount, LocalDate date) {
        operations.add(new Withdrawal(amount, date));
    }

    public Amount getBalance() {
        BalanceAwareOperationVisitor balanceAwareOperationVisitor = new BalanceAwareOperationVisitor();
        for (Operation operation : operations) {
            operation.accept(balanceAwareOperationVisitor);
        }
        return balanceAwareOperationVisitor.getBalance();
    }

    public Operations getOperations() {
        return operations;
    }

}
