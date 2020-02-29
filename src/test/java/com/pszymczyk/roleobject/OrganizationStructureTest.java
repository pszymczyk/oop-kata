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
        Developer rubyDeveloper = getDeveloper("ruby");
        facade.addPersonToOrganization(rubyDeveloper);

        //when
        Developer developer = facade.getDeveloper(rubyDeveloper.getId());

        //then
        assertThat(developer.getProgramingLanguages()).containsExactly("ruby");
    }

    @Test
    public void testAdminSkills() {
        //given
        Administrator kubernetesAdministrator = getAdministrator("kubernetes");
        facade.addPersonToOrganization(kubernetesAdministrator);

        //when
        Administrator administrator = facade.getAdministrator(kubernetesAdministrator.getId());

        //then
        assertThat(administrator.getSupportedSystems()).containsExactly("kubernetes");
    }

    @Test
    public void notAllDevelopersAreAdmins() {
        //given
        Developer rubyDeveloper = getDeveloper("ruby");
        facade.addPersonToOrganization(rubyDeveloper);

        //when
        Developer developer = facade.getDeveloper(rubyDeveloper.getId());

        //then
        assertThat(developer.getProgramingLanguages()).containsExactly("ruby");

        //and
        Throwable thrown = Assertions.catchThrowable(() -> facade.getAdministrator(developer.getId()));

        //then
        assertThat(thrown).isInstanceOf(CouldNotFindGivenRole.class).hasMessageContaining(Administrator.class.getSimpleName());
    }

    @Test
    public void notAllAdminsAreDevelopers() {
        //given
        Administrator kubernetesAdministrator = getAdministrator("kubernetes");
        facade.addPersonToOrganization(kubernetesAdministrator);

        //when
        Administrator administrator = facade.getAdministrator(kubernetesAdministrator.getId());

        //then
        assertThat(administrator.getSupportedSystems()).containsExactly("kubernetes");

        //and
        Throwable thrown = Assertions.catchThrowable(() -> facade.getDeveloper(administrator.getId()));

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
        Developer developer = facade.getDeveloper(person.getId());

        //then
        assertThat(developer.getProgramingLanguages())
                .containsExactly("go");

        //and
        Administrator administrator = facade.getAdministrator(person.getId());

        //then
        assertThat(administrator.getSupportedSystems())
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
