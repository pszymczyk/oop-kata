package com.pszymczyk.polymorphism.tariff;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;

/**
 * @author pawel szymczyk
 */
public interface TaxiTariffElement {

    Money calculate(RideSummary rideSummary);

}
