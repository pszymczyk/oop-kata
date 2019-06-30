package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

public class ShortTravelFee implements Fee {

    @Override
    public Money calculate(RideSummary rideSummary) {
        if (rideSummary.getDistanceInKm() < 3) {
            return new Money("5");
        }

        return Money.zero();
    }
}
