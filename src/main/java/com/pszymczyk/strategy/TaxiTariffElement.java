package com.pszymczyk.strategy;

import java.time.LocalDate;

import com.pszymczyk.generic.Money;

/**
 * @author pawel szymczyk
 */
public interface TaxiTariffElement {

    boolean isApplicable(Driver driver, LocalDate time);

    Money calculate(RideSummary rideSummary);

}
