package com.pszymczyk.roleobject;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
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
        Person developer = getDeveloper("ruby");
        facade.addPersonToOrganization(developer);

        //when
        List<String> programmingLanguages = facade.getProgrammingLanguagesOf(developer.getId());

        //then
        assertThat(programmingLanguages).containsExactly("ruby");
    }

    @Test
    public void testAdminSkills() {
        //given
        Person administrator = getAdministrator("kubernetes");
        facade.addPersonToOrganization(administrator);

        //when
        List<String> supportedSystems = facade.getSupportedSystemsOf(administrator.getId());

        //then
        assertThat(supportedSystems).containsExactly("kubernetes");
    }

    @Test
    public void notAllDevelopersAreAdmins() {
        //given
        Person developer = getDeveloper("ruby");
        facade.addPersonToOrganization(developer);

        //when
        List<String> programmingLanguages = facade.getProgrammingLanguagesOf(developer.getId());

        //then
        assertThat(programmingLanguages).containsExactly("ruby");

        //and
        Throwable thrown = Assertions.catchThrowable(() -> facade.getSupportedSystemsOf(developer.getId()));

        //then
        assertThat(thrown).isInstanceOf(CouldNotFindGivenRole.class).hasMessageContaining(Administrator.class.getSimpleName());
    }

    @Test
    public void notAllAdminsAreDevelopers() {
        //given
        Person administrator = getAdministrator("kubernetes");
        facade.addPersonToOrganization(administrator);

        //when
        List<String> supportedSystems = facade.getSupportedSystemsOf(administrator.getId());

        //then
        assertThat(supportedSystems).containsExactly("kubernetes");

        //and
        Throwable thrown = Assertions.catchThrowable(() -> facade.getProgrammingLanguagesOf(administrator.getId()));

        //then
        assertThat(thrown).isInstanceOf(CouldNotFindGivenRole.class).hasMessageContaining(Developer.class.getSimpleName());
    }

    @Test
    public void testDevopsSkills() {
        //given
        Person person = getDeveloper("go");
        Administrator administrator = new Administrator();
        administrator.addSupportedSystem("kubernetes");
        person.addRole(administrator);
        facade.addPersonToOrganization(person);

        //when
        List<String> programmingLanguages = facade.getProgrammingLanguagesOf(person.getId());

        //then
        assertThat(programmingLanguages)
                .containsExactly("go");

        //and
        List<String> supportedSystems = facade.getSupportedSystemsOf(person.getId());

        //then
        assertThat(supportedSystems)
                .containsExactly("kubernetes");
    }

    private Person getDeveloper(String language) {
        Developer developer = new Developer();
        developer.addKnownLanguage(language);
        Person person = new Person("developer_" + randomInt());
        person.addRole(developer);
        return person;
    }

    private Person getAdministrator(String supportedSystem) {
        Administrator administrator = new Administrator();
        administrator.addSupportedSystem(supportedSystem);
        Person person = new Person("administrator_" + randomInt());
        person.addRole(administrator);
        return person;
    }

    private int randomInt() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
