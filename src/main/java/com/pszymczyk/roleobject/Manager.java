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

    List<Salesman> getSubordinateSalesman() {
        return subordinates.stream()
                .filter(person -> person.hasRole("salesman"))
                .map(person -> person.roleOf("salesman", Salesman.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasType(String roleName) {
        return "manager".equalsIgnoreCase(roleName);
    }
}
