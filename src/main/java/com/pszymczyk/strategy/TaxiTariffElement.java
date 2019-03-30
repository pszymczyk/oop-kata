package com.pszymczyk.strategy;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;

/**
 * @author pawel szymczyk
 */
public interface TaxiTariffElement {

    boolean isApplicable(Driver driver, LocalDateTime time);

    Money calculate(RideSummary rideSummary);

}
