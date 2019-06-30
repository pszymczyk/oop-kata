package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

/**
 * @author pawel szymczyk
 */
public class KmFee implements Fee {

    private final Money feePerMinute = new Money("2");

    public Money calculate(RideSummary rideSummary) {
        return feePerMinute.multiply(rideSummary.getDistanceInKm());
    }
}
