package com.pszymczyk.party;

/**
 * @author pawel szymczyk
 */
class Accountability {

    private final AccountabilityType accountabilityType;
    private final Party party;

    public Accountability(AccountabilityType accountabilityType, Party party) {
        this.accountabilityType = accountabilityType;
        this.party = party;
    }

    public AccountabilityType getAccountabilityType() {
        return accountabilityType;
    }

    public Party getParty() {
        return party;
    }
}
