package com.pszymczyk.inheritance.domainevents;

import java.util.UUID;

/**
 * @author pawel szymczyk
 */
interface DomainEvent {

    default UUID getID() {
        return UUID.randomUUID();
    }
}
