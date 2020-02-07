package com.pszymczyk.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void Should_return_zero_when_no_arguments_given() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void Should_return_argument_when_one_argument_given() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add("5");

        //then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void Should_sum_of_two_arguments() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add("5");

        //then
        assertThat(result).isEqualTo(5);
    }
}
