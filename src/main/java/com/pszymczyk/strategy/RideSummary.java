package com.pszymczyk.strategy;

import java.time.Duration;
import java.time.Instant;

/**
 * @author pawel szymczyk
 */
public class RideSummary {
    private final int distanceInKm;
    private final Instant startTime;
    private final Duration duration;

    public RideSummary(int distanceInKm, Instant startTime, Duration duration) {
        this.distanceInKm = distanceInKm;
        this.startTime = startTime;
        this.duration = duration;
    }

    public int getDistanceInKm() {
        return distanceInKm;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public Duration getDuration() {
        return duration;
    }
}
