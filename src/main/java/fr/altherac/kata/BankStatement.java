package fr.altherac.kata;

import java.util.ArrayList;
import java.util.List;

public class BankStatement {

    private final Account account;

    public BankStatement(Account account) {
        this.account = account;
    }

    public List<String> print() {
        List<String> statements = new ArrayList<>();
        statements.add("date || credit || debit || balance");

        BankStatementPrinter printer = new BankStatementPrinter();
        printer.print(account.getOperations());

        statements.addAll(printer.getPrintedOutput());

        return statements;
    }

}
