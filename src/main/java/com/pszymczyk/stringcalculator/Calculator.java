package com.pszymczyk.stringcalculator;

class Calculator {

    public int add(String parameters) {
        if (parameters.isEmpty()) {
            return 0;
        }

        return Integer.valueOf(parameters);
    }
}
