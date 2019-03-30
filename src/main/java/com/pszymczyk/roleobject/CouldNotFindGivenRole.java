package com.pszymczyk.roleobject;

class CouldNotFindGivenRole extends RuntimeException {

    CouldNotFindGivenRole(String personId, String roleName) {
        super(personId + " has no role " + roleName);
    }
}
