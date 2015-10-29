package fr.altherac.kata;

import java.util.ArrayList;
import java.util.List;

public class BankStatementPrinter implements OperationVisitor {

    private final List<String> printedOutput = new ArrayList<>();

    private final PrintableDateFormatter printableDateFormatter = new PrintableDateFormatter();

    private final PrintableAmountFormatter printableAmountFormatter = new PrintableAmountFormatter();

    @Override
    public void visit(Deposit deposit) {
        String printableAmount = printableAmountFormatter.printableAmount(deposit.getAmount());
        String printed = String.format("%s || %s || || %s", printableDateFormatter.printableDate(deposit.getDate()), printableAmount, printableAmount);
        printedOutput.add(printed);
    }

    @Override
    public void visit(Withdrawal withdrawal) {
        String printableAmount = printableAmountFormatter.printableAmount(withdrawal.getAmount());
        String printed = String.format("%s || || %s || -%s", printableDateFormatter.printableDate(withdrawal.getDate()), printableAmount, printableAmount);
        printedOutput.add(printed);
    }

    public void print(Operations operations) {
        for (Operation operation : operations) {
            operation.accept(this);
        }
    }

    public List<String> getPrintedOutput() {
        return printedOutput;
    }
}
