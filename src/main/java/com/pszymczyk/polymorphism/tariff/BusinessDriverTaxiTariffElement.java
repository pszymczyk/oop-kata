package com.pszymczyk.polymorphism.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.Driver;
import com.pszymczyk.polymorphism.RideSummary;
import com.pszymczyk.polymorphism.TaxiTariffElement;

public class BusinessDriverTaxiTariffElement implements TaxiTariffElement {

    @Override
    public boolean isApplicable(Driver driver, LocalDateTime time) {
        return driver.isBusiness();
    }

    @Override
    public Money calculate(RideSummary rideSummary) {
        return new Money("10");
    }
}
