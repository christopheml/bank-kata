package fr.altherac.kata.operation;

public interface OperationVisitor {

    void visit(Deposit deposit);

    void visit(Withdrawal withdrawal);

}
