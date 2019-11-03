package com.pszymczyk.stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_when_no_args_given() {
        //when
        int result = new Calculator().add("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_argument_when_one_argument_passed() {
        //when
        int result = new Calculator().add("3");

        //then
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void should_return_add_two_arguments() {
        //when
        int result = new Calculator().add("3,4");

        //then
        assertThat(result).isEqualTo(7);
    }

}
