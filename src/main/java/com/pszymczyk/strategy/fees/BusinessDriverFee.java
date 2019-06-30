package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

public class BusinessDriverFee implements Fee {

    @Override
    public Money calculate(RideSummary rideSummary) {
        return new Money("10");
    }
}
