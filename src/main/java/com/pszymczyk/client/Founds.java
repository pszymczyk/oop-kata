package com.pszymczyk.client;

import com.pszymczyk.generic.Money;

public class Founds {

    private Money founds;
    private Money debt;
    private Money creditLimit;

    public static Founds zero() {
        return new Founds(Money.zero());
    }

    private Founds(Money founds) {
        this.founds = founds;
    }

    public Founds subtract(Money price) {
        return null;
    }

    public boolean canAfford(Money price) {
        return false;
    }
}
