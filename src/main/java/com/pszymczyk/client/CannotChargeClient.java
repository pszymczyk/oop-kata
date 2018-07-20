package com.pszymczyk.client;

import com.pszymczyk.generic.Money;

public class CannotChargeClient extends RuntimeException {

    public CannotChargeClient(Money money) {
        super("Cannot charge client for " + money);
    }
}