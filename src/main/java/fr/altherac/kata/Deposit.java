package fr.altherac.kata;

import java.time.LocalDate;

public class Deposit extends Operation {

    public Deposit(Amount amount, LocalDate date) {
        super(amount, date);
    }

    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }

}
