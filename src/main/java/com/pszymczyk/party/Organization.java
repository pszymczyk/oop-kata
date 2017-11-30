package com.pszymczyk.party;

/**
 * @author pawel szymczyk
 */
class Organization extends Party {

    public Organization(Party parent, Address address, PhoneNumber phoneNumber) {
        super(parent, address, phoneNumber);
    }

    public Organization(Address address, PhoneNumber phoneNumber) {
        super(address, phoneNumber);
    }
}
