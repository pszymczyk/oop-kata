package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
public class RideSummary {
    private final int timeInMinutes;
    private final int distanceInKm;

    public RideSummary(int timeInMinutes, int DistanceInKm) {
        this.timeInMinutes = timeInMinutes;
        distanceInKm = DistanceInKm;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }
}
