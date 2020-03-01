package com.pszymczyk.strategy;

class TaximeterFactory {

    TaximeterFactory() {
    }

    Taximeter create(Driver driver) {
        BillingStrategy billingStrategy = null;
        if (!driver.isBusiness() && !driver.isRegular()) { // not configured already
            billingStrategy = BillingStrategy.defaultStrategy();
        }else if (driver.isBusiness()) {
            billingStrategy = BillingStrategy.businessStrategy();
        } else {
            billingStrategy = BillingStrategy.regularStrategy();
        }

        return new Taximeter(billingStrategy);
    }
}
