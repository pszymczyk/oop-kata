package com.pszymczyk.strategy;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.pszymczyk.strategy.Money.zero;
import static java.time.ZoneId.systemDefault;

/**
 * @author pawel szymczyk
 */
class Taximeter {

    private final List<Bill> bills;

    Taximeter() {
        this.bills = new LinkedList<>();
    }

    void finish(Driver driver, RideSummary rideSummary, Clock clock) {
        if (!driver.isBusiness() && !driver.isRegular()) { // not configured already
            Money newOneFee = zero().add(new Money("1").multiply(rideSummary.getDistanceInKm()))
                                    .add(new Money("1").multiply(rideSummary.getDuration().toMinutes())
                                                       .add(new Money("5")));
            bills.add(new Bill(newOneFee, LocalDate.now(clock)));
            return;
        }

        Money sum = zero();
        sum = sum.add(new Money("2").multiply(rideSummary.getDistanceInKm()));
        if (driver.isBusiness()) {
            sum = sum.add(new Money("10"));
        }
        // door slam fee
        sum = sum.add(new Money("5"))

        .add(new Money("5").multiply(rideSummary.getDuration().toMinutes()));

        LocalDateTime startTime = LocalDateTime.ofInstant(rideSummary.getStartTime(), systemDefault());
        if (startTime.isAfter(localTime(startTime, 22)) || startTime.isBefore(localTime(startTime, 5))) {
            sum = sum.add(new Money("2").multiply(rideSummary.getDistanceInKm()));
        }

        bills.add(new Bill(sum, LocalDate.now(clock)));
    }

    Money sumUpTheDay(LocalDate date) {
        return bills.stream()
                    .filter(bill -> bill.fromDay(date))
                    .map(bill -> bill.getFee())
                    .reduce(zero(), Money::add);
    }

    private LocalDateTime localTime(LocalDateTime startTime, int i) {
        return startTime.toLocalDate().atTime(i, 0);
    }
}
