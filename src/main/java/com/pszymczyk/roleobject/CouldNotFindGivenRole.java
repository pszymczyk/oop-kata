package com.pszymczyk.roleobject;

public class CouldNotFindGivenRole extends RuntimeException {

    public CouldNotFindGivenRole(String personId, String roleName) {
        super(personId + " has no role " + roleName);
    }
}
