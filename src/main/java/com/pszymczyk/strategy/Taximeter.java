package com.pszymczyk.strategy;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static com.pszymczyk.strategy.Money.zero;

/**
 * @author pawel szymczyk
 */
class Taximeter {

    private final List<Bill> bills;
    private final BillingStrategy billingStrategy;

    Taximeter(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
        this.bills = new LinkedList<>();
    }

    void finish(RideSummary rideSummary, Clock clock) {
        Money sum = billingStrategy.calculate(rideSummary);
        bills.add(new Bill(sum, LocalDate.now(clock)));
    }

    Money sumUpTheDay(LocalDate date) {
        return bills.stream()
                    .filter(bill -> bill.fromDay(date))
                    .map(bill -> bill.getFee())
                    .reduce(zero(), Money::add);
    }

    public static LocalDateTime localTime(LocalDateTime startTime, int i) {
        return startTime.toLocalDate().atTime(i, 0);
    }
}
