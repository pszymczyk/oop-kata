package com.pszymczyk.roleobject;

import java.util.List;

class UsageExample {

    static void main(String... args) {
        Person person = new Person();
        person.addRole(new Manager());

        if (person.hasRole("manager")) {
            Manager manager = person.roleOf("manager", Manager.class);
            List<Developer> developers = manager.getSubordinateDevelopers();

            developers.forEach(developer -> System.out.println("Hi I am developer and I can develop in " + developer.programingLanguages()));
        }
    }
}
