package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

/**
 * @author pawel szymczyk
 */
public class DoorsSlamFee implements Fee {

    private static final Money doorSlamFee = new Money("5");

    public Money calculate(RideSummary rideSummary) {
        return doorSlamFee;
    }
}