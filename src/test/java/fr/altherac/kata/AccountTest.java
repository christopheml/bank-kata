package fr.altherac.kata;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest  {


    @Test
    public void given_a_new_bank_account_when_asking_balance_then_balance_should_be_zero() {
        Account account = given_a_new_bank_account();
        then_balance_should_be(account, 0);
    }

    @Test
    public void given_a_new_bank_account_with_a_deposit_of_1000_when_asking_balance_then_balance_should_be_1000() {
        Account account = given_a_new_bank_account();
        given_a_deposit_of(account, 1000);
        then_balance_should_be(account, 1000);
    }

    private void given_a_deposit_of(Account account, int amount) {
        account.deposit(amount, LocalDate.now());
    }

    private void then_balance_should_be(Account account, int expectedBalance) {
        assertThat(account.getBalance()).isEqualTo(BigDecimal.valueOf(expectedBalance));
    }

    private Account given_a_new_bank_account() {
        return new Account();
    }

}
