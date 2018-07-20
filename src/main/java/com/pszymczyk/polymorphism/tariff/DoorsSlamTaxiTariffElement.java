package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
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


    public Money calculate(RideSummary rideSummary) {
        return doorSlamFee;
    }
}