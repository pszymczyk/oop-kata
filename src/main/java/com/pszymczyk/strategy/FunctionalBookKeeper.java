//package com.pszymczyk.strategy;
//
//import java.util.function.Function;
//
///**
// * @author pawel szymczyk
// */
//class FunctionalBookKeeper {
//
//    public Invoice issue(Order order, RebatePolicy rebatePolicy, TaxPolicy taxPolicy) {
//        Money total = Money.ZERO;
//
//        total = total.minus(rebatePolicy.calculateRebate(order));
//        total = total.plus(taxPolicy.calculateTax(order));
//
//            /*
//                do smth smart here
//            */
//        return null;
//    }
//
//
//    static class FunctionalBookKeeperExecution {
//
//        void sampleFunctionBookKeeperExecution() {
//
//            FunctionalBookKeeper functionalBookKeeper = new FunctionalBookKeeper();
//            Order order = new Order();
//
//            functionalBookKeeper.issue(order, RebatePolicy.vipRabatePolicy(),
//                    o -> {
//                        //do another smart things here
//                        return new Money();
//                    });
//        }
//    }
//}
