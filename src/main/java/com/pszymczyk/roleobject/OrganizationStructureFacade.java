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

        Developer developer = person.getRole(Developer.class)
                                    .orElseThrow(() -> new CouldNotFindGivenRole(personId, Developer.class.getSimpleName()));
        return developer.getProgramingLanguages();
    }

    List<String> getSupportedSystemsOf(String personId) {
        Person person = isPartOfOrganization(personId);


        Administrator administrator = person.getRole(Administrator.class)
                                            .orElseThrow(() -> new CouldNotFindGivenRole(personId, Administrator.class.getSimpleName()));
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
