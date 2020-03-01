package com.pszymczyk.strategy;

class TaximeterFactory {

    TaximeterFactory() {
    }

    Taximeter create(Driver driver) {
        //TODO get appropriate BillingStrategy for Driver and pass it to Taximeter
        return new Taximeter();
    }
}
