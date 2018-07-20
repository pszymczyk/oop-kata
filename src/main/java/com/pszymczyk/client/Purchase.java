package com.pszymczyk.client;

import com.pszymczyk.generic.Money;

import java.time.Instant;
import java.util.Objects;

/**
 * @author pawel szymczyk
 */
public class Purchase {
    private final Money price;
    private final String service;
    private final Instant occurrenceTime;

    public Purchase(Service service, Instant occurrenceTime) {
        this.price = service.getPrice();
        this.service = service.getName();
        this.occurrenceTime = occurrenceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return Objects.equals(price, purchase.price) &&
                Objects.equals(service, purchase.service) &&
                Objects.equals(occurrenceTime, purchase.occurrenceTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(price, service, occurrenceTime);
    }

    public Money getPrice() {
        return price;
    }

    public String getService() {
        return service;
    }

    public Instant getOccurrenceTime() {
        return occurrenceTime;
    }
}
