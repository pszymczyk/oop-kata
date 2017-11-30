package com.pszymczyk.party;

import java.util.Set;

/**
 * @author pawel szymczyk
 */
abstract class AccountabilityType {

    private Set<Accountability> accountabilities;

    protected AccountabilityType(Set<Accountability> accountabilities) {
        this.accountabilities = accountabilities;
    }

    public Set<Accountability> getAccountabilities() {
        return accountabilities;
    }
}
