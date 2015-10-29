package fr.altherac.kata;

import fr.altherac.kata.statement.BankStatement;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankStatementTest {

    private static final String STATEMENT_HEADER = "date || credit || debit || balance";

    @Test
    public void given_an_empty_account_when_printing_statement_then_print_only_header() {
        BankStatement statement = new BankStatement(new Account());
        List<String> printedStatement = statement.print();
        assertThat(printedStatement).containsExactly(STATEMENT_HEADER);
    }

    @Test
    public void given_a_new_bank_account_with_a_deposit_of_1000_when_printing_statement_then_print_the_deposit() {
        Account account = new Account();
        account.deposit(Amount.of(1000), LocalDate.of(2015, 10, 20));

        BankStatement bankStatement = new BankStatement(account);
        List<String> printedStatement = bankStatement.print();
        assertThat(printedStatement).containsExactly(STATEMENT_HEADER, "20/10/2015 || 1000.00 || || 1000.00");
    }

    @Test
    public void given_a_new_bank_account_with_a_withdrawal_of_900_when_printing_statement_then_print_the_withdrawal() {
        Account account = new Account();
        account.withdraw(Amount.of(900), LocalDate.of(2015, 10, 20));

        BankStatement bankStatement = new BankStatement(account);
        List<String> printedStatement = bankStatement.print();
        assertThat(printedStatement).containsExactly(STATEMENT_HEADER, "20/10/2015 || || 900.00 || -900.00");
    }

    @Test
    public void given_a_bank_account_with_two_operations_when_printing_statement_then_order_and_balance_are_right() {
        Account account = new Account();
        account.withdraw(Amount.of(200), LocalDate.of(2015, 10, 22));
        account.deposit(Amount.of(1000), LocalDate.of(2015, 10, 20));

        BankStatement bankStatement = new BankStatement(account);
        List<String> printedStatement = bankStatement.print();
        assertThat(printedStatement).containsExactly(
                STATEMENT_HEADER,
                "22/10/2015 || || 200.00 || 800.00",
                "20/10/2015 || 1000.00 || || 1000.00");
    }

}
