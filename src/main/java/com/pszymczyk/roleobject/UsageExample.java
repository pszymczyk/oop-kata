package com.pszymczyk.roleobject;

import java.util.List;

public class UsageExample {

    public static void main(String... args) {
        //create
        Person javaDeveloper = new Person();
        javaDeveloper.addRole(new Developer("Java"));

        Person pythonDeveloper = new Person();
        pythonDeveloper.addRole(new Developer("Python"));

        Person teamLeader = new Person();
        teamLeader.addRole(new TeamLeader());
        teamLeader.addRole(new Developer("Java", "Python", "Go"));
        teamLeader.addRole(new Administrator());
        teamLeader.roleOf("lead", TeamLeader.class).addSubordinate(javaDeveloper);
        teamLeader.roleOf("lead", TeamLeader.class).addSubordinate(pythonDeveloper);

        //read
        if (teamLeader.hasRole("lead")) {
            System.out.println("Hi I am team lead and my subordinate developers know many different programming languages: ");
            TeamLeader lead = teamLeader.roleOf("lead", TeamLeader.class);
            List<Developer> developers = lead.getSubordinateDevelopers();
            developers.forEach(developer -> System.out.println(developer.programingLanguages()));
        }

        if (teamLeader.hasRole("developer")) {
            System.out.println("I can also develop some code, I know:");
            Developer dev = teamLeader.roleOf("developer", Developer.class);
            dev.programingLanguages().forEach(System.out::println);
        }

        if (teamLeader.hasRole("admin")) {
            System.out.println("I am also administrator, I manage:");
            Administrator administrator = teamLeader.roleOf("admin", Administrator.class);
            administrator.getSupportedSustems().forEach(System.out::println);
        }
    }
}
