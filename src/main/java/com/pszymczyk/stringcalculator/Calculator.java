package com.pszymczyk.stringcalculator;

public class Calculator {

    public int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        String[] split = s.split(",");

        if (split.length == 1) {
            return Integer.valueOf(s);
        }

        return Integer.valueOf(split[0]) + Integer.valueOf(split[1]);
    }
}
