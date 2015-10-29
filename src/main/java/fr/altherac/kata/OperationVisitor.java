package fr.altherac.kata;

public interface OperationVisitor {

    void visit(Deposit deposit);

    void visit(Withdrawal withdrawal);

}
