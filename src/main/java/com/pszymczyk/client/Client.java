package com.pszymczyk.client;

import java.time.Instant;

/**
 * @author pawel szymczyk
 */
public class Client {

    private Founds founds;

    public Client() {
        this(Founds.zero());
    }

    public Client(Founds founds) {
        this.founds = founds;
    }

    public Purchase charge(Service service) {
        if (!canAfford(service)) {
            throw new CannotChargeClient(service.getPrice());
        }

        founds = founds.subtract(service.getPrice());

        return new Purchase(service, Instant.now());
    }

    public boolean canAfford(Service service) {
        return founds.canAfford(service.getPrice());
    }
}
