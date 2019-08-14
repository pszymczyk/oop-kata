package com.pszymczyk.stringcalculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void shouldReturnZeroWhenNoArgumentPassed() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add("");

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldReturnArgumentWhenOneArgumentPassed() {
        //given
        Calculator calculator = new Calculator();

        //when
        int result = calculator.add("5");

        //then
        assertThat(result).isEqualTo(5);
    }
}
