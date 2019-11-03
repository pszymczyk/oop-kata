package com.pszymczyk.roleobject;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void shouldAddRole() {
        //given
        Person person = new Person("kazik");

        //when
        person.addRole(new Developer());

        //then
        assertThat(person.getRole(Developer.class))
                .isPresent()
                .containsInstanceOf(PersonRole.class);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenCannotFindGivenRoleOptional() {
        //given
        Person person = new Person("kazik");

        //when
        person.addRole(new Developer());

        //then
        assertThat(person.getRole(Administrator.class)).isEmpty();
    }
}
