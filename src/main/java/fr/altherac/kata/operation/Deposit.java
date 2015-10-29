package fr.altherac.kata.operation;

import fr.altherac.kata.Amount;

import java.time.LocalDate;

public class Deposit extends Operation {

    public Deposit(Amount amount, LocalDate date) {
        super(amount, date);
    }

    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }

}
