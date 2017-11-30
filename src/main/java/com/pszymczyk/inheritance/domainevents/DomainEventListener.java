package com.pszymczyk.inheritance.domainevents;

/**
 * @author pawel szymczyk
 */
class DomainEventListener {

    private final DomainEventStorage eventStorage;

    DomainEventListener(DomainEventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    void handleEvent(DomainEvent domainEvent) {
        eventStorage.persist(domainEvent);
    }

}
