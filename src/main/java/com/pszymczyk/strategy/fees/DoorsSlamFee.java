package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

/**
 * @author pawel szymczyk
 */
public class DoorsSlamFee implements Fee {

    private final Money doorSlamFee;

    public DoorsSlamFee(Money doorSlamFee) {
        this.doorSlamFee = doorSlamFee;
    }

    public Money calculate(RideSummary rideSummary) {
        return doorSlamFee;
    }
}