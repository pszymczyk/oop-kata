package com.pszymczyk.polymorphism;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.TaxiTariffElement;

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
        Money cost = Money.zero();
        for (TaxiTariffElement element: taxiTariffElements) {
            cost = cost.add(element.calculate(rideSummary));
        }

        return cost;
    }
}
