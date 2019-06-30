package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

/**
 * @author pawel szymczyk
 */
public class TimeFee implements Fee {

    private static final Money feePerMinute = new Money("5");

    public Money calculate(RideSummary rideSummary) {
        return feePerMinute.multiply(rideSummary.getDuration().toMinutes());
    }
}
