package fr.altherac.kata;

import java.math.BigDecimal;

public class Amount {

    private final BigDecimal value;

    private Amount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public static Amount of(int amount) {
        return new Amount(BigDecimal.valueOf(amount));
    }

    public static Amount of(BigDecimal amount) {
        return new Amount(amount);
    }

    public Amount add(Amount amount) {
        return Amount.of(getValue().add(amount.getValue()));
    }

    public Amount subtract(Amount amount) {
        return Amount.of(getValue().subtract(amount.getValue()));
    }

}
