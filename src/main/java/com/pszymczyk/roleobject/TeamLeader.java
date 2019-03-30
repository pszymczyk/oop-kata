package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TeamLeader extends PersonRole {

    private final List<Person> subordinates;

    TeamLeader() {
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
        return "lead".equalsIgnoreCase(roleName);
    }
}
