package com.pszymczyk.gearbox;

public interface GearCalculator {

    int calculate(int currentGear, int currentRPM, double gasThreshold, double breakingForce);
}
