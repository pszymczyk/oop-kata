package com.pszymczyk.stringcalculator;

import static java.lang.Integer.valueOf;

public class Calculator {

    public static final String SEPARATOR = ",";

    public int add(String givenArguments) {
        if (noArguments(givenArguments)) {
            return 0;
        }

        return add(givenArguments.split(SEPARATOR));
    }

    private int add(String[] arguments) {
        if (exactlyOneArgument(arguments)) {
            return valueOf(arguments[0]);
        }

        return add(valueOf(arguments[0]), valueOf(arguments[1]));
    }

    private int add(int x, int y) {
        return x + y;
    }

    private boolean exactlyOneArgument(String[] parameters) {
        return parameters.length < 2;
    }

    private boolean noArguments(String arguments) {
        return arguments.length() == 0;
    }
}
