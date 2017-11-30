package com.pszymczyk.party;

/**
 * @author pawel szymczyk
 */
class Shelter extends Party {
    protected Shelter(Party parent, Address address, PhoneNumber phoneNumber) {
        super(parent, address, phoneNumber);
    }

    protected Shelter(Address address, PhoneNumber phoneNumber) {
        super(address, phoneNumber);
    }
}
