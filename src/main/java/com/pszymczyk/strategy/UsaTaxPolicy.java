package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
class UsaTaxPolicy implements TaxPolicy {
    @Override
    public Money calculateTax(Order order) {
        return null;
    }
}
