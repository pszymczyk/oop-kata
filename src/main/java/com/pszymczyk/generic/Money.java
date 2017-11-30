package com.pszymczyk.generic;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author pawel szymczyk
 */
public class Money {

    private final BigDecimal value;

    public Money(String value) {
        this(new BigDecimal(value));
    }

    private Money(BigDecimal value) {
        this.value = value;
    }

    public static Money zero() {
        return new Money(BigDecimal.ZERO);
    }

    public Money add(Money money) {
        return new Money(value.add(money.value));
    }

    public Money multiply(int timeInMinutes) {
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

    public boolean lessOrEqualTo(Money money) {
        return money.value.compareTo(value) <= 0;
    }
}
