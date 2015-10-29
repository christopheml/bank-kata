package fr.altherac.kata;

import org.junit.Test;

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
        given_a_deposit_of(account, Amount.of(1000));
        then_balance_should_be(account, 1000);
    }

    @Test
    public void given_a_new_bank_account_with_a_withdrawal_of_500_when_asking_balance_then_balance_should_be_minus_500() {
        Account account = given_a_new_bank_account();
        given_a_withdrawal_of(account, Amount.of(500));
        then_balance_should_be(account, -500);
    }

    private void given_a_withdrawal_of(Account account, Amount amount) {
        account.withdraw(amount, LocalDate.now());
    }

    private void given_a_deposit_of(Account account, Amount amount) {
        account.deposit(amount, LocalDate.now());
    }

    private void then_balance_should_be(Account account, int expectedBalance) {
        assertThat(account.getBalance()).isEqualTo(Amount.of(expectedBalance));
    }

    private Account given_a_new_bank_account() {
        return new Account();
    }

}
