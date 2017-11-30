package com.pszymczyk.inheritance.domainevents;

import java.util.UUID;

/**
 * @author pawel szymczyk
 */
abstract class DomainEvent {

    UUID getID() {
        return UUID.randomUUID();
    }
}
