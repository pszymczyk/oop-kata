package com.pszymczyk.party;

import java.util.Set;

/**
 * @author pawel szymczyk
 */
class Employee extends AccountabilityType {
    protected Employee(Set<Accountability> accountabilities) {
        super(accountabilities);
    }
}
