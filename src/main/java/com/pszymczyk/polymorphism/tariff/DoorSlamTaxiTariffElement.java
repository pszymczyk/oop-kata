package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;

/**
 * @author pawel szymczyk
 */
class DoorSlamTaxiTariffElement implements TaxiTariffElement{

    private final Money doorSlamFee;

    DoorSlamTaxiTariffElement(Money doorSlamFee) {
        this.doorSlamFee = doorSlamFee;
    }


    public Money calculate(RideSummary rideSummary) {
        return doorSlamFee;
    }
}