package com.pszymczyk.strategy;

public interface BillingStrategy {

    Money calculate(RideSummary rideSummary);

    static BillingStrategy defaultStrategy() {
        return rideSummary -> Money.zero();
    }
}
