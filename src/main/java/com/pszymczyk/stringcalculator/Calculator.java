package com.pszymczyk.stringcalculator;

import static java.lang.Integer.valueOf;

class Calculator {

    int add(String args) {
        if (args.isEmpty()) {
            return 0;
        }

        String[] split = args.split(",");
        if (split.length == 1) {
            return valueOf(split[0]);
        }

        return valueOf(split[0]) + valueOf(split[1]);
    }
}
