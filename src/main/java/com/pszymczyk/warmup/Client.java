package com.pszymczyk.warmup;

import com.pszymczyk.generic.Money;

/**
 * @author pawel szymczyk
 */
public class Client {

    private Money founds;

    public Client() {
        this(Money.zero());
    }

    public Client(Money founds) {
        this.founds = founds;
    }

    public Purchase charge(Money money) {
        if (!canAfford(money)) {
            throw new CannotChargeClient(money);
        }

        founds = founds.substract(money);

        return new Purchase(money);
    }

    public boolean canAfford(Money money) {
        return founds.lessOrEqualTo(money);
    }
}
