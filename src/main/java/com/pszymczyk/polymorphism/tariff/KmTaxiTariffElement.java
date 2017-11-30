package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;

/**
 * @author pawel szymczyk
 */
class KmTaxiTariffElement implements TaxiTariffElement{

    private final Money feePerMinute;

    KmTaxiTariffElement(Money feePerMinute) {
        this.feePerMinute = feePerMinute;
    }

    public Money calculate(RideSummary rideSummary) {
        return feePerMinute.multiply(rideSummary.getDistanceInKm());
    }
}
