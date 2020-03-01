package com.pszymczyk.roleobject;

import java.util.Optional;

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
        assertThat(person.getRole(Developer.class)).isPresent()
                                                   .get()
                                                   .isInstanceOf(PersonRole.class)
                                                   .isNotInstanceOf(Person.class);
    }

    @Test
    public void shouldReturnEmptyOptionalWhenCannotFindGivenRoleOptional() {
        //given
        Person person = new Person("kazik");

        //when
        person.addRole(new Developer());

        //then
        Optional<Administrator> administrator = person.getRole(Administrator.class);
        assertThat(administrator).isEmpty();
    }
}
