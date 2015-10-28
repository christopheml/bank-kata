package fr.altherac.kata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BankStatementPrinter implements OperationVisitor {

    private final List<String> printedOutput = new ArrayList<>();

    @Override
    public void visit(Operation operation) {
        String printableAmount = printableAmount(operation.getAmount());
        String printed = String.format("%s || %s || || %s", printableDate(operation.getDate()), printableAmount, printableAmount);
        printedOutput.add(printed);
    }

    private String printableAmount(Amount amount) {
        return String.format(Locale.ENGLISH, "%.2f", amount.getValue());
    }

    private String printableDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("d/M/y").toFormatter();
        return date.format(dateTimeFormatter);
    }

    public void print(List<Operation> operations) {
        for (Operation operation : operations) {
            operation.accept(this);
        }
    }

    public List<String> getPrintedOutput() {
        return printedOutput;
    }
}
