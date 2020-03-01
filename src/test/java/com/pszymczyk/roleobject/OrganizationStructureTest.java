package com.pszymczyk.roleobject;

import java.util.concurrent.ThreadLocalRandom;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrganizationStructureTest {

    OrganizationStructureFacade facade;

    @Before
    public void setup() {
        facade = new OrganizationStructureFacade();
    }

    @Test
    public void testDeveloperSkills() {
        //given
        String personId = "developer_" + randomInt();
        facade.addPersonToOrganization(getDeveloper(personId));

        //when
        Developer developer = facade.getDeveloper(personId);

        //then
        assertThat(developer.getProgramingLanguages()).containsExactly("ruby");
    }

    @Test
    public void testAdminSkills() {
        //given
        String personId = "administrator_" + randomInt();
        facade.addPersonToOrganization(getAdministrator(personId));

        //when
        Administrator administrator = facade.getAdministrator(personId);

        //then
        assertThat(administrator.getSupportedSystems()).containsExactly("kubernetes");
    }

    @Test
    public void notAllDevelopersAreAdmins() {
        //given
        String personId = "developer_" + randomInt();
        facade.addPersonToOrganization(getDeveloper(personId));

        //when
        Developer developer = facade.getDeveloper(personId);

        //then
        assertThat(developer.getProgramingLanguages()).containsExactly("ruby");

        //and
        Throwable thrown = Assertions.catchThrowable(() -> facade.getAdministrator(personId));

        //then
        assertThat(thrown).isInstanceOf(CouldNotFindGivenRole.class).hasMessageContaining(Administrator.class.getSimpleName());
    }

    @Test
    public void notAllAdminsAreDevelopers() {
        //given
        String personId = "administrator_" + randomInt();
        facade.addPersonToOrganization(getAdministrator(personId));

        //when
        Administrator administrator = facade.getAdministrator(personId);

        //then
        assertThat(administrator.getSupportedSystems()).containsExactly("kubernetes");

        //and
        Throwable thrown = Assertions.catchThrowable(() -> facade.getDeveloper(personId));

        //then
        assertThat(thrown).isInstanceOf(CouldNotFindGivenRole.class).hasMessageContaining(Developer.class.getSimpleName());
    }

    @Test
    public void testDevopsSkills() {
        //given
        String personId = "devops_" + randomInt();
        facade.addPersonToOrganization(getDevops(personId));

        //when
        Developer developer = facade.getDeveloper(personId);

        //then
        assertThat(developer.getProgramingLanguages()).containsExactly("go");

        //and
        Administrator administrator = facade.getAdministrator(personId);

        //then
        assertThat(administrator.getSupportedSystems()).containsExactly("kubernetes");
    }

    private Person getDevops(String personId) {
        Person person = new Person(personId);
        Developer developer = new Developer();
        developer.addKnownLanguage("go");
        person.addRole(developer);
        Administrator administrator = new Administrator();
        administrator.addSupportedSystem("kubernetes");
        person.addRole(administrator);
        return person;
    }

    private Person getDeveloper(String personId) {
        Person person = new Person(personId);
        Developer developer = new Developer();
        developer.addKnownLanguage("ruby");
        person.addRole(developer);
        return person;
    }

    private Person getAdministrator(String personId) {
        Person person = new Person(personId);
        Administrator administrator = new Administrator();
        administrator.addSupportedSystem("kubernetes");
        person.addRole(administrator);
        return person;
    }

    private int randomInt() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
