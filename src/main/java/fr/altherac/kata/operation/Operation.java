package fr.altherac.kata.operation;

import fr.altherac.kata.Amount;

import java.time.LocalDate;

public abstract class Operation {

    private final Amount amount;

    private final LocalDate date;

    public Operation(Amount amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public abstract void accept(OperationVisitor visitor);

    public abstract Amount applyTo(Amount balance);
}
