package com.pszymczyk.strategy.tariff;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.Driver;
import com.pszymczyk.strategy.RideSummary;
import com.pszymczyk.strategy.TaxiTariffElement;

import static java.time.ZoneId.systemDefault;

public class NightTaxiTariffElement implements TaxiTariffElement {

    @Override
    public boolean isApplicable(Driver driver, LocalDate time) {
        return true;
    }

    @Override
    public Money calculate(RideSummary rideSummary) {
        LocalDateTime startTime = LocalDateTime.ofInstant(rideSummary.getStartTime(), systemDefault());

        if (startTime.isAfter(localTime(startTime, 22)) || startTime.isBefore(localTime(startTime, 5))) {
            return new Money("2").multiply(rideSummary.getDistanceInKm());
        }

        return Money.zero();
    }

    private LocalDateTime localTime(LocalDateTime startTime, int i) {
        return startTime.toLocalDate().atTime(i, 0);
    }
}
