package com.pszymczyk.roleobject;

class Salesman extends PersonRole {

    public int numberOfSales () {
        return 99882;
    };

    @Override
    boolean hasType(String roleName) {
        return "salesman".equalsIgnoreCase(roleName);
    }
}
