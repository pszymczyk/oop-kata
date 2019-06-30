package com.pszymczyk.strategy;

import java.util.Map;

class TaximeterFactory {

    private final Map<Driver, BillingStrategy> driversBillingConfiguration;

    TaximeterFactory(Map<Driver, BillingStrategy> driversBillingConfiguration) {
        this.driversBillingConfiguration = driversBillingConfiguration;
    }

    Taximeter create(Driver driver) {
        return new Taximeter(driversBillingConfiguration.getOrDefault(driver, BillingStrategy.defaultStrategy()));
    }
}
