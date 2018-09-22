package com.pszymczyk.polymorphism.tariff;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.Driver;
import com.pszymczyk.polymorphism.RideSummary;
import com.pszymczyk.polymorphism.TaxiTariffElement;

/**
 * @author pawel szymczyk
 */
public class DoorsSlamTaxiTariffElement implements TaxiTariffElement {

    private final Money doorSlamFee;

    public DoorsSlamTaxiTariffElement(Money doorSlamFee) {
        this.doorSlamFee = doorSlamFee;
    }

    @Override
    public boolean isApplicable(Driver driver, LocalDateTime time) {
        return true;
    }

    public Money calculate(RideSummary rideSummary) {
        return doorSlamFee;
    }
}