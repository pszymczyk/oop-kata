package com.pszymczyk.roleobject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrganizationStructureFacade {

    private Map<String, Person> organization = new HashMap<>();

    public void addPersonToOrganization(Person person) {
        organization.put(person.getId(), person);
    }

    Developer getDeveloper(String personId) {
        Person person = isPartOfOrganization(personId);

        if (!person.getRole(Developer.class).isPresent()){
            throw new CouldNotFindGivenRole(person.getId(), Developer.class.getSimpleName());
        }

        return person.getRole(Developer.class).get();
    }

    Administrator getAdministrator(String personId) {
        Person person = isPartOfOrganization(personId);

        if (!person.getRole(Administrator.class).isPresent()){
            throw new CouldNotFindGivenRole(person.getId(), Administrator.class.getSimpleName());
        }

        return person.getRole(Administrator.class).get();
    }

    private Person isPartOfOrganization(String personId) {
        Person person = organization.get(personId);
        if (person == null) {
            throw new IllegalArgumentException("Cannot find person with given id " + personId);
        }
        return person;
    }
}
