package fr.altherac.kata;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest  {


    @Test
    public void given_a_new_bank_account_when_asking_balance_then_balance_should_be_zero() {
        Account account = new Account();
        assertThat(account.getBalance()).isZero();
    }

}
