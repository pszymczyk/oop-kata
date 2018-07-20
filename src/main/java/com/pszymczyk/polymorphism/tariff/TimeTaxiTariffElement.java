package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;
import com.pszymczyk.polymorphism.TaxiTariffElement;

/**
 * @author pawel szymczyk
 */
class TimeTaxiTariffElement implements TaxiTariffElement {

    private final Money feePerMinute;

    TimeTaxiTariffElement(Money feePerMinute) {
        this.feePerMinute = feePerMinute;
    }

    public Money calculate(RideSummary rideSummary) {
        return feePerMinute.multiply(rideSummary.getTimeInMinutes());
    }
}
