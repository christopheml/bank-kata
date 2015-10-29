package fr.altherac.kata.operation;

import fr.altherac.kata.Amount;

import java.time.LocalDate;

public class Withdrawal extends Operation {

    public Withdrawal(Amount amount, LocalDate date) {
        super(amount, date);
    }

    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
