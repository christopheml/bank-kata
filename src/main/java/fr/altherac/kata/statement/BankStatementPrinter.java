package fr.altherac.kata.statement;

import fr.altherac.kata.operation.*;

import java.util.LinkedList;
import java.util.List;

public class BankStatementPrinter extends BalanceAwareOperationVisitor {

    private final List<String> printedOutput = new LinkedList<>();

    private final PrintableDateFormatter printableDateFormatter = new PrintableDateFormatter();

    private final PrintableAmountFormatter printableAmountFormatter = new PrintableAmountFormatter();

    @Override
    public void visit(Deposit deposit) {
        super.visit(deposit);
        printOperation(deposit, "%s || %s || || %s");
    }

    @Override
    public void visit(Withdrawal withdrawal) {
        super.visit(withdrawal);
        printOperation(withdrawal, "%s || || %s || %s");
    }

    private void printOperation(Operation operation, String lineFormat) {
        String printed = String.format(lineFormat,
                printableDateFormatter.printableDate(operation.getDate()),
                printableAmountFormatter.printableAmount(operation.getAmount()),
                printableAmountFormatter.printableAmount(getBalance()));
        printedOutput.add(0, printed);
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
