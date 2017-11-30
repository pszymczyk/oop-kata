package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
interface TaxPolicy {
    Money calculateTax(Order order);
}
