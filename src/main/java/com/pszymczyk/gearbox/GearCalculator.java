package com.pszymczyk.gearbox;

public interface GearCalculator {

    int calculate(int currentRPM, double threshold, double force);
}
