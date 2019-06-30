package com.pszymczyk.strategy;

import java.util.Arrays;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.fees.Fee;

import static com.pszymczyk.generic.Money.zero;

public interface BillingStrategy {

    Money calculate(RideSummary rideSummary);

    static BillingStrategy defaultStrategy() {
        return rideSummary ->
                zero().add(new Money("1").multiply(rideSummary.getDistanceInKm()))
                      .add(new Money("1").multiply(rideSummary.getDuration().toMinutes())
                      .add(new Money("5")));
    }

    static BillingStrategy feesChain(Fee... fee) {
        return rideSummary -> Arrays.asList(fee)
                                    .stream()
                                    .map(e -> e.calculate(rideSummary))
                                    .reduce(zero(), Money::add);
    }
}
