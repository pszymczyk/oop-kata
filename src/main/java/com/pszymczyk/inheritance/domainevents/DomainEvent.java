package com.pszymczyk.inheritance.domainevents;

import java.util.UUID;

/**
 * @author pawel szymczyk
 */
class DomainEvent {

    UUID getID() {
        return UUID.randomUUID();
    }
}
