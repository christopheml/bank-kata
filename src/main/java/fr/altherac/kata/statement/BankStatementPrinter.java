package fr.altherac.kata.statement;

import fr.altherac.kata.operation.*;

import java.util.ArrayList;
import java.util.List;

public class BankStatementPrinter extends BalanceAwareOperationVisitor {

    private final List<String> printedOutput = new ArrayList<>();

    private final PrintableDateFormatter printableDateFormatter = new PrintableDateFormatter();

    private final PrintableAmountFormatter printableAmountFormatter = new PrintableAmountFormatter();

    @Override
    public void visit(Deposit deposit) {
        super.visit(deposit);
        String printed = String.format("%s || %s || || %s",
                printableDateFormatter.printableDate(deposit.getDate()),
                printableAmountFormatter.printableAmount(deposit.getAmount()),
                printableAmountFormatter.printableAmount(getBalance()));
        printedOutput.add(0, printed);
    }

    @Override
    public void visit(Withdrawal withdrawal) {
        super.visit(withdrawal);
        String printed = String.format("%s || || %s || %s",
                printableDateFormatter.printableDate(withdrawal.getDate()),
                printableAmountFormatter.printableAmount(withdrawal.getAmount()),
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
