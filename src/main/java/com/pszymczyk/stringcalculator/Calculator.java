package com.pszymczyk.stringcalculator;

public class Calculator {

    public int add(String args) {
        if (args.isEmpty()) {
            return 0;
        }

        char first = args.charAt(0);
        char second = args.charAt(2);

        return Integer.valueOf(args);
    }
}
