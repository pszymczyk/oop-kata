package com.pszymczyk.inheritance.templatemethod;

/**
 * @author pawel szymczyk
 */
abstract class BetterThanJunitTestRunner {

    abstract void setup();
    abstract Object execute();
    abstract boolean checkResult(Object result);

    void runTest() throws Exception {
        setup();
        Object result = execute();
        if (!checkResult(result)) {
            throw new TestFailedException();
        }
    }
}
