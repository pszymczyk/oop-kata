package com.pszymczyk.polymorphism;

import com.pszymczyk.generic.Money;

import java.util.List;

/**
 * @author pawel szymczyk
 */
class Taximeter {

    private final List<TaxiTariffElement> taxiTariffElements;

    public Taximeter(List<TaxiTariffElement> taxiTariffElements) {
        this.taxiTariffElements = taxiTariffElements;
    }

    public Money calculate(RideSummary rideSummary) {
        return taxiTariffElements.stream()
                                 .map(taxiTariffElement -> taxiTariffElement.calculate(rideSummary))
                                 .reduce(Money::add)
                                 .orElse(Money.zero());
    }
}
