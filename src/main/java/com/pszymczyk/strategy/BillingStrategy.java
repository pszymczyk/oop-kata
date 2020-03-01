package com.pszymczyk.strategy;

public interface BillingStrategy {

    Money calculate(RideSummary rideSummary);

    static BillingStrategy defaultStrategy() {
        //TODO
        return rideSummary -> Money.zero();
    }
}
