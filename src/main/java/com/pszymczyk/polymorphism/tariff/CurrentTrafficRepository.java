package com.pszymczyk.polymorphism.tariff;

/**
 * @author pawel szymczyk
 */
public class CurrentTrafficRepository {

    private final long waitingClients;
    private final long availableCars;

    public CurrentTrafficRepository(long waitingClients, long availableCars) {
        this.waitingClients = waitingClients;
        this.availableCars = availableCars;
    }

    long waitingClients() {
        return waitingClients;
    }

    long availableCars() {
        return availableCars;
    }
}
