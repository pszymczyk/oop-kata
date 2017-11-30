package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
class BookKeeper {

    private TaxPolicy taxPolicy;
    private RebatePolicy rebatePolicy;

    public Invoice issue(Order order){
        Money total = Money.ZERO;

        total = total.minus(rebatePolicy.calculateRebate(order));
        total = total.plus(taxPolicy.calculateTax(order));

        /*
         do smth smart here
        */
        return null;
    }
}
