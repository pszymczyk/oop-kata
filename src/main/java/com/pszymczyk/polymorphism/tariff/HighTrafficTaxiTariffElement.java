package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;
import com.pszymczyk.polymorphism.TaxiTariffElement;

/**
 * @author pawel szymczyk
 */
public class HighTrafficTaxiTariffElement implements TaxiTariffElement {

    private final long waitingClientsLimit;
    private final long availableCarsLimit;
    private final CurrentTrafficRepository currentTrafficRepository;

    public HighTrafficTaxiTariffElement(long waitingClientsLimit, long availableCarsLimit,
                                        CurrentTrafficRepository currentTrafficRepository) {
        this.waitingClientsLimit = waitingClientsLimit;
        this.availableCarsLimit = availableCarsLimit;
        this.currentTrafficRepository = currentTrafficRepository;
    }

    @Override
    public Money calculate(RideSummary rideSummary) {
        if (currentTrafficRepository.availableCars() == availableCarsLimit
                && currentTrafficRepository.waitingClients() > waitingClientsLimit) {
            return new Money("10");
        }

        return Money.zero();
    }
}
