package com.pszymczyk.party;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pawel szymczyk
 */
abstract class Party {

    private final Address address;
    private final PhoneNumber phoneNumber;
    private final Set<Accountability> accountabilities;

    private Party parent;

    protected Party(Party parent, Address address, PhoneNumber phoneNumber) {
        this(address, phoneNumber);
        this.parent = parent;
    }

    protected Party(Address address, PhoneNumber phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.accountabilities = new HashSet<>();

    }

    public void addRole(AccountabilityType accountabilityType) {
        accountabilities.add(new Accountability(accountabilityType, this));
    }

    public void removeRole(AccountabilityType accountabilityType) {
        accountabilities.remove(new Accountability(accountabilityType, this));
    }

    public Set<Accountability> getAccountabilities() {
        return Collections.unmodifiableSet(accountabilities);
    }

    public Party getParent() {
        return parent;
    }
}
