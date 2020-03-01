package com.pszymczyk.roleobject;

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
    @Ignore
    public void testDevopsSkills() {
        //given
        String personId = "devops_" + randomInt();
        Person person = new Person(personId);
        //TODO
        facade.addPersonToOrganization(person);

        //when
        Developer developer = facade.getDeveloper(personId);

        //then
        assertThat(developer.getProgramingLanguages()).containsExactly("go");

        //and
        Administrator administrator = facade.getAdministrator(personId);

        //then
        assertThat(administrator.getSupportedSystems()).containsExactly("kubernetes");
    }

    private Developer getDeveloper(String personId) {
        Developer developer = new Developer(personId);
        developer.addKnownLanguage("ruby");
        return developer;
    }

    private Administrator getAdministrator(String personId) {
        Administrator administrator = new Administrator(personId);
        administrator.addSupportedSystem("kubernetes");
        return administrator;
    }

    private int randomInt() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
