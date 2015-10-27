package fr.altherac.kata.acceptance;

import fr.altherac.kata.Account;
import fr.altherac.kata.Amount;
import fr.altherac.kata.BankStatement;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAcceptanceTest {


    @Test
    public void given_an_account_with_operations_when_generating_statement_then_statement_shows_all_operations() {
        Account account = new Account();
        account.deposit(Amount.of(1000), LocalDate.of(2012, 1, 10));
        account.deposit(Amount.of(2000), LocalDate.of(2012, 1, 13));
        account.withdraw(Amount.of(500), LocalDate.of(2012, 1, 14));

        BankStatement statement = new BankStatement(account);
        List<String> printedStatement =  statement.print();

        assertThat(printedStatement).containsExactly(
                "date || credit || debit || balance",
                "14/01/2012 || || 500.00 || 2500.00",
                "13/01/2012 || 2000 || || 3000.00",
                "10/01/2012 || 1000 || || 1000.00"
        );
    }
}
