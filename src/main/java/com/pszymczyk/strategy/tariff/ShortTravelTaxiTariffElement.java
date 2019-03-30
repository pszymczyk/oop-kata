package com.pszymczyk.strategy.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.Driver;
import com.pszymczyk.strategy.RideSummary;
import com.pszymczyk.strategy.TaxiTariffElement;

public class ShortTravelTaxiTariffElement implements TaxiTariffElement {

    @Override
    public boolean isApplicable(Driver driver, LocalDateTime time) {
        return true;
    }

    @Override
    public Money calculate(RideSummary rideSummary) {
        if (rideSummary.getDistanceInKm() < 3) {
            return new Money("5");
        }

        return Money.zero();
    }
}
