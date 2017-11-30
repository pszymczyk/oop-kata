package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;

/**
 * @author pawel szymczyk
 */
class HighTrafficTaxiTariffElement implements TaxiTariffElement{

    private final long waitingClients;
    private final long availableCars;

    public HighTrafficTaxiTariffElement(long waitingClients, long availableCars) {
        this.waitingClients = waitingClients;
        this.availableCars = availableCars;
    }

    @Override
    public Money calculate(RideSummary rideSummary) {

        //do sth

        return new Money("doSth");
    }
}
