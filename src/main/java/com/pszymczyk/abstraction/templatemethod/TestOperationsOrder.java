package com.pszymczyk.abstraction.templatemethod;

/**
 * @author pawel szymczyk
 */
class TestOperationsOrder extends BetterThanJunitTestRunner {

    private int a, b, c ;

    @Override
    void setup() {
        a = 2;
        b = 4;
        c = 8;
    }

    @Override
    Object execute() {
        return a * b + c;
    }

    @Override
    boolean checkResult(Object result) {
        return result.equals(16);
    }
}
