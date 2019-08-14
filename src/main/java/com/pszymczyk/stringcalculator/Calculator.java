package com.pszymczyk.stringcalculator;

class Calculator {

    public int add(String parameters) {
        if (parameters.isEmpty()) {
            return 0;
        }

        if (!parameters.contains(",")) {
            return Integer.valueOf(parameters);
        }

        return Integer.valueOf(parameters.charAt(0)+"") + Integer.valueOf(parameters.charAt(2)+"");
    }
}
