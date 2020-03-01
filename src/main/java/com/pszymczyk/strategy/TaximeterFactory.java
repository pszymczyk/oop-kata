package com.pszymczyk.strategy;

class TaximeterFactory {

    TaximeterFactory() {
    }

    Taximeter create(Driver driver) {
        return new Taximeter();
    }
}
