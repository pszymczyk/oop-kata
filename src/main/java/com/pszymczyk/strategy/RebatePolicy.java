package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
interface RebatePolicy {
    Money calculateRebate(Order order);

//    static RebatePolicy christmasRabatePolicy() {
//        return order -> null;
//    }
//
//    static RebatePolicy vipRabatePolicy() {
//        return order -> null;
//    }
//
//    static RebatePolicy poorMansRabatePolicy() {
//        return order -> null;
//    }
}
