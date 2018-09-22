package com.pszymczyk.polymorphism.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.Driver;
import com.pszymczyk.polymorphism.RideSummary;
import com.pszymczyk.polymorphism.TaxiTariffElement;

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
