package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Manager extends PersonRole {

    private final List<Person> subordinates;

    Manager() {
        this.subordinates = new ArrayList<>();
    }

    void addSubordinate(Person person) {
        subordinates.add(person);
    }

    List<Developer> getSubordinateDevelopers() {
        return subordinates.stream()
                .filter(person -> person.hasRole("developer"))
                .map(person -> person.roleOf("developer", Developer.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasType(String roleName) {
        return "manager".equalsIgnoreCase(roleName);
    }
}
