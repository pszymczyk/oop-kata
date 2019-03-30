package com.pszymczyk.strategy.tariff;

import java.time.LocalDate;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.Driver;
import com.pszymczyk.strategy.RideSummary;
import com.pszymczyk.strategy.TaxiTariffElement;

/**
 * @author pawel szymczyk
 */
public class DoorsSlamTaxiTariffElement implements TaxiTariffElement {

    private final Money doorSlamFee;

    public DoorsSlamTaxiTariffElement(Money doorSlamFee) {
        this.doorSlamFee = doorSlamFee;
    }

    @Override
    public boolean isApplicable(Driver driver, LocalDate time) {
        return true;
    }

    public Money calculate(RideSummary rideSummary) {
        return doorSlamFee;
    }
}