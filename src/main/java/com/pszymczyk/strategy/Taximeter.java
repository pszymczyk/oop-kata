package com.pszymczyk.strategy;

import java.time.Clock;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import com.pszymczyk.generic.Money;

import static java.util.Objects.requireNonNull;

/**
 * @author pawel szymczyk
 */
class Taximeter {

    private final List<Bill> bills;
    private BillingStrategy billingStrategy;

    Taximeter(BillingStrategy billingStrategy) {
        this.bills = new LinkedList<>();
        this.billingStrategy = billingStrategy;
    }

    void updateBillingStrategy(BillingStrategy billingStrategy) {
        requireNonNull(billingStrategy);

        this.billingStrategy = billingStrategy;
    }

    void finish(RideSummary rideSummary, Clock clock) {
        bills.add(new Bill(billingStrategy.calculate(rideSummary), LocalDate.now(clock)));
    }

    Money sumUpTheDay(LocalDate date) {
        return bills.stream()
             .filter(bill -> bill.fromDay(date))
             .map(bill -> bill.getFee())
             .reduce(Money.zero(), Money::add);
    }
}
