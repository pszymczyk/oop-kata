package com.pszymczyk.strategy;

import java.time.LocalDateTime;

import static com.pszymczyk.strategy.Money.zero;
import static java.time.ZoneId.systemDefault;

public interface BillingStrategy {

    Money calculate(RideSummary rideSummary);

    static BillingStrategy defaultStrategy() {
        return (rideSummary) -> zero().add(new Money("1").multiply(rideSummary.getDistanceInKm()))
                                      .add(new Money("1").multiply(rideSummary.getDuration().toMinutes())
                                                         .add(new Money("5")));
    }

    static BillingStrategy businessStrategy() {
        return (rideSummary) -> {
            Money sum = zero();
            sum = sum.add(new Money("2").multiply(rideSummary.getDistanceInKm()));
            sum = sum.add(new Money("10"));
            // door slam fee
            sum = sum.add(new Money("5")).add(new Money("5").multiply(rideSummary.getDuration().toMinutes()));

            LocalDateTime startTime = LocalDateTime.ofInstant(rideSummary.getStartTime(), systemDefault());
            if (startTime.isAfter(Taximeter.localTime(startTime, 22)) || startTime.isBefore(Taximeter.localTime(startTime, 5))) {
                sum = sum.add(new Money("2").multiply(rideSummary.getDistanceInKm()));
            }
            return sum;
        };
    }

    static BillingStrategy regularStrategy() {
        return (rideSummary) -> {
            Money sum = zero();
            sum = sum.add(new Money("2").multiply(rideSummary.getDistanceInKm()));
            // door slam fee
            sum = sum.add(new Money("5"))

                     .add(new Money("5").multiply(rideSummary.getDuration().toMinutes()));

            LocalDateTime startTime = LocalDateTime.ofInstant(rideSummary.getStartTime(), systemDefault());
            if (startTime.isAfter(Taximeter.localTime(startTime, 22)) || startTime.isBefore(Taximeter.localTime(startTime, 5))) {
                sum = sum.add(new Money("2").multiply(rideSummary.getDistanceInKm()));
            }
            return sum;
        };
    }
}
