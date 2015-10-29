package fr.altherac.kata.operation;

import fr.altherac.kata.Amount;

public class BalanceAwareOperationVisitor implements OperationVisitor {

    private Amount balance = Amount.of(0);

    @Override
    public void visit(Deposit deposit) {
        balance = deposit.applyTo(balance);
    }

    @Override
    public void visit(Withdrawal withdrawal) {
        balance = withdrawal.applyTo(balance);
    }

    public Amount getBalance() {
        return balance;
    }

}
