package com.pszymczyk.polymorphism;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.tariff.TaxiTariffElement;

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
