package com.pszymczyk.polymorphism;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.tariff.*;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pawel szymczyk
 */
public class TaximeterTest {

    @Test
    public void shouldCalculatePriceFromGivenTariff() {
        //given
        CurrentTrafficRepository currentTrafficRepository = new CurrentTrafficRepository(100, 0);
        TaxiTariffElement highTrafficTaxiTariffElement = new HighTrafficTaxiTariffElement(10, 0, currentTrafficRepository);
        TaxiTariffElement kmTaxiTariffElement = new KmTaxiTariffElement(new Money("10"));
        TaxiTariffElement doorsSlamTaxiTariffElement = new DoorsSlamTaxiTariffElement(new Money("10"));

        //when
        Money cost = new Taximeter(Arrays.asList(highTrafficTaxiTariffElement, kmTaxiTariffElement, doorsSlamTaxiTariffElement))
                .calculate(new RideSummary(10, 10));

        //then
        assertThat(cost).isEqualTo(new Money("120"));
    }

}