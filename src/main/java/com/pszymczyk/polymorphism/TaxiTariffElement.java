package com.pszymczyk.polymorphism;

import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.RideSummary;

/**
 * @author pawel szymczyk
 */
public interface TaxiTariffElement {

    boolean isApplicable(Driver driver, LocalDateTime time);

    Money calculate(RideSummary rideSummary);

}
