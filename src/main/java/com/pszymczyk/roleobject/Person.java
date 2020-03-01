package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class Person {

    private final String id;
    private final List<PersonRole> roles = new ArrayList<>();

    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    void addRole(PersonRole value) {
        roles.add(value);
    }

    <T extends PersonRole> Optional<T> getRole(Class<T> tClass) {
        return roles.stream()
                    .filter(role -> role.getClass().isAssignableFrom(tClass))
                    .map(tClass::cast)
                    .findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
