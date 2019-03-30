package com.pszymczyk.strategy.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.Driver;
import com.pszymczyk.strategy.RideSummary;
import com.pszymczyk.strategy.TaxiTariffElement;

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
