package com.pszymczyk.strategy;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author pawel szymczyk
 */
class Money {

    private final BigDecimal value;

    Money(String value) {
        this(new BigDecimal(value));
    }

    private Money(BigDecimal value) {
        this.value = value;
    }

    static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    Money add(Money money) {
        return new Money(value.add(money.value));
    }

    Money multiply(long timeInMinutes) {
        return new Money(value.multiply(new BigDecimal(timeInMinutes)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value.compareTo(money.value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    boolean lessOrEqualTo(Money money) {
        return money.value.compareTo(value) <= 0;
    }

    Money subtract(Money money) {
        return new Money(value.subtract(money.value));
    }
}
