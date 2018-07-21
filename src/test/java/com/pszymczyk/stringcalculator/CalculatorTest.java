package com.pszymczyk.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private static final Calculator calculator = new Calculator();

    @Test
    public void shouldReturnZeroWhenNoArgumentsGiven() {
        //when
        int result = calculator.add("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnGivenArgumentWhenOneArgumentPassed() {
        //when
        int result = calculator.add("3999");

        //then
        assertThat(result).isEqualTo(3999);
    }

    @Test
    public void shouldAddTwoArguments() {
        //when
        int result = calculator.add("3,9");

        //then
        assertThat(result).isEqualTo(12);
    }

    @Test
    public void shouldAddTwoBiggerNumbers() {
        //when
        int result = calculator.add("500,500");

        //then
        assertThat(result).isEqualTo(1000);
    }

}