package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;

class Person {

    private String id;
    private final List<PersonRole> roles;

    Person() {
        this.roles = new ArrayList<>();
    }

    void addRole(PersonRole value) {
        roles.add(value);
    }

    boolean hasRole(String roleName) {
        return roles.stream()
                .anyMatch(role -> role.hasType(roleName));

    }

    <T extends PersonRole> T roleOf(String roleName, Class<T> tClass) {
        return roles.stream()
             .filter(role -> role.hasType(roleName))
             .map(role -> tClass.cast(role))
             .findAny()
             .orElseThrow(() -> new CouldNotFindGivenRole(this.id, roleName));
    }
}
