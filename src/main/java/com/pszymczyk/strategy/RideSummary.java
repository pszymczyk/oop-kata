package com.pszymczyk.strategy;

import java.time.Duration;
import java.time.Instant;

/**
 * @author pawel szymczyk
 */
class RideSummary {
    private final int distanceInKm;
    private final Instant startTime;
    private final Duration duration;

    RideSummary(int distanceInKm, Instant startTime, Duration duration) {
        this.distanceInKm = distanceInKm;
        this.startTime = startTime;
        this.duration = duration;
    }

    int getDistanceInKm() {
        return distanceInKm;
    }

    Instant getStartTime() {
        return startTime;
    }

    Duration getDuration() {
        return duration;
    }
}
