package com.pszymczyk.gearbox;

public interface GearCalculator {

    int calculate(int curentRPM, double threshold, double force);
}
