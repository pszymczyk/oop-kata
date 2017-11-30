package com.pszymczyk.warmup;

import com.pszymczyk.generic.Money;

import java.util.Objects;

/**
 * @author pawel szymczyk
 */
public class Purchase {
    private Money money;

    public Purchase(Money money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(money, purchase.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
