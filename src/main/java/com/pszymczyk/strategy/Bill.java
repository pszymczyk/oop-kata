package com.pszymczyk.strategy;

import java.time.LocalDate;

import com.pszymczyk.generic.Money;

class Bill {

    private final Money fee;
    private final LocalDate date;

    Bill(Money fee, LocalDate date) {
        this.fee = fee;
        this.date = date;
    }

    Money getFee() {
        return fee;
    }

    public boolean fromDay(LocalDate date) {
        return this.date.equals(date);
    }
}
