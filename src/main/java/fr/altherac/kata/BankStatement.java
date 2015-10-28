package fr.altherac.kata;

import java.util.Arrays;
import java.util.List;

public class BankStatement {

    public BankStatement(Account account) {
    }

    public List<String> print() {
        return Arrays.asList("date || credit || debit || balance");
    }

}
