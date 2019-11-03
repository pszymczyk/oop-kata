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
        Developer developer = getDeveloper("ruby");
        facade.addPersonToOrganization(developer);

        //when
        List<String> programmingLanguages = facade.getProgrammingLanguagesOf(developer.getId());

        //then
        assertThat(programmingLanguages).containsExactly("ruby");
    }

    @Test
    public void testAdminSkills() {
        //given
        Administrator administrator = getAdministrator("kubernetes");
        facade.addPersonToOrganization(administrator);

        //when
        List<String> supportedSystems = facade.getSupportedSystemsOf(administrator.getId());

        //then
        assertThat(supportedSystems).containsExactly("kubernetes");
    }

    @Test
    public void notAllDevelopersAreAdmins() {
        //given
        Developer developer = getDeveloper("ruby");
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
        Administrator administrator = getAdministrator("kubernetes");
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
    @Ignore
    public void testDevopsSkills() {
        //given
        Person person = new Person("kazik");
        //TODO
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

    private Developer getDeveloper(String language) {
        Developer developer = new Developer("developer_" + randomInt());
        developer.addKnownLanguage(language);
        return developer;
    }

    private Administrator getAdministrator(String supportedSystem) {
        Administrator administrator = new Administrator("administrator_" + randomInt());
        administrator.addSupportedSystem(supportedSystem);
        return administrator;
    }

    private int randomInt() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
