package fr.altherac.kata;

import java.time.LocalDate;

public class Withdrawal extends Operation {

    public Withdrawal(Amount amount, LocalDate date) {
        super(amount, date);
    }

    public void accept(OperationVisitor visitor) {
        visitor.visit(this);
    }
}
