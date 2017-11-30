package com.pszymczyk.party;

/**
 * @author pawel szymczyk
 */
class Person extends Party {
    protected Person(Party parent, Address address, PhoneNumber phoneNumber) {
        super(parent, address, phoneNumber);
    }

    protected Person(Address address, PhoneNumber phoneNumber) {
        super(address, phoneNumber);
    }
}
