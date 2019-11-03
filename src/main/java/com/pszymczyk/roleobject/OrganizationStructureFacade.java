package com.pszymczyk.roleobject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class OrganizationStructureFacade {

    private Map<String, Person> organization = new HashMap<>();

    public void addPersonToOrganization(Person person) {
        organization.put(person.getId(), person);
    }

    List<String> getProgrammingLanguagesOf(String personId) {
        Person person = isPartOfOrganization(personId);

        if (!Developer.class.isAssignableFrom(person.getClass())){
            throw new CouldNotFindGivenRole(person.getId(), Developer.class.getSimpleName());
        }

        Developer developer = (Developer) person;
        return developer.getProgramingLanguages();
    }

    List<String> getSupportedSystemsOf(String personId) {
        Person person = isPartOfOrganization(personId);

        if (!Administrator.class.isAssignableFrom(person.getClass())){
            throw new CouldNotFindGivenRole(person.getId(), Administrator.class.getSimpleName());
        }

        Administrator administrator = (Administrator) person;
        return administrator.getSupportedSystems();
    }

    private Person isPartOfOrganization(String personId) {
        Person person = organization.get(personId);
        if (person == null) {
            throw new IllegalArgumentException("Cannot find person with given id " + personId);
        }
        return person;
    }
}
