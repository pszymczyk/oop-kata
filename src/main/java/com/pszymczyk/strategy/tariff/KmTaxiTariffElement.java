package com.pszymczyk.strategy.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.Driver;
import com.pszymczyk.strategy.RideSummary;
import com.pszymczyk.strategy.TaxiTariffElement;

/**
 * @author pawel szymczyk
 */
public class KmTaxiTariffElement implements TaxiTariffElement {

    private final Money feePerMinute;

    public KmTaxiTariffElement(Money feePerMinute) {
        this.feePerMinute = feePerMinute;
    }

    @Override
    public boolean isApplicable(Driver driver, LocalDateTime time) {
        return true;
    }

    public Money calculate(RideSummary rideSummary) {
        return feePerMinute.multiply(rideSummary.getDistanceInKm());
    }
}
