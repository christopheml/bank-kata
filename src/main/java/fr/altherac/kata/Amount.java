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

    public Amount add(Amount amount) {
        return new Amount(getValue().add(amount.getValue()));
    }

    public Amount subtract(Amount amount) {
        return new Amount(getValue().subtract(amount.getValue()));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Amount && value.equals(((Amount) other).getValue());
    }

}
