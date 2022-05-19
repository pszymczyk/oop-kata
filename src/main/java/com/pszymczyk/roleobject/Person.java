package com.pszymczyk.roleobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class Person {

    private final String id;
    private final List<PersonRole> roles;

    public Person(String id) {
        this.id = id;
        this.roles = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    void addRole(PersonRole personRole) {
        roles.add(personRole);
    }
    <T extends PersonRole> Optional<T> getRole(Class<T> tClass) {
        T role = null;
        for (PersonRole p: roles) {
            if (tClass.equals(p.getClass())) {
                role = tClass.cast(p);
                break;
            }
        }

        return Optional.ofNullable(role);
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
