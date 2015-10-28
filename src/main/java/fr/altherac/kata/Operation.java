package fr.altherac.kata;

import java.time.LocalDate;

public class Operation {

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

    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }

}
