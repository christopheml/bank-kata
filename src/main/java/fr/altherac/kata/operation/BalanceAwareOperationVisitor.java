package fr.altherac.kata.operation;

import fr.altherac.kata.Amount;

import java.math.BigDecimal;

public class BalanceAwareOperationVisitor implements OperationVisitor {

    private BigDecimal balance = BigDecimal.ZERO;

    @Override
    public void visit(Deposit deposit) {
        balance = balance.add(deposit.getAmount().getValue());
    }

    @Override
    public void visit(Withdrawal withdrawal) {
        balance = balance.subtract(withdrawal.getAmount().getValue());
    }

    public Amount getBalance() {
        return Amount.of(balance);
    }

}
