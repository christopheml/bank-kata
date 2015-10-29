package fr.altherac.kata.statement;

import fr.altherac.kata.Amount;

import java.util.Locale;

public class PrintableAmountFormatter {

    public String printableAmount(Amount amount) {
        return String.format(Locale.ENGLISH, "%.2f", amount.getValue());
    }

}
