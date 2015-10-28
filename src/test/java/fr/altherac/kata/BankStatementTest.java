package fr.altherac.kata;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankStatementTest {

    @Test
    public void given_an_empty_account_when_printing_statement_then_print_only_header() {
        BankStatement statement = new BankStatement(new Account());
        List<String> printedStatement = statement.print();
        assertThat(printedStatement).containsExactly("date || credit || debit || balance");
    }

}