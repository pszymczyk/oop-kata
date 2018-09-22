package com.pszymczyk.polymorphism.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.Driver;
import com.pszymczyk.polymorphism.RideSummary;
import com.pszymczyk.polymorphism.TaxiTariffElement;

public class NightTaxiTariffElement implements TaxiTariffElement {

    @Override
    public boolean isApplicable(Driver driver, LocalDateTime time) {
        return time.getHour() > 22 || time.getHour() < 5;
    }

    @Override
    public Money calculate(RideSummary rideSummary) {
        return new Money("2").multiply(rideSummary.getDistanceInKm());
    }
}
