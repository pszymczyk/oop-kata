package com.pszymczyk.strategy;

import java.time.Clock;

import org.junit.Test;

import com.pszymczyk.generic.Money;

import static java.time.Duration.ofMinutes;
import static java.time.Instant.now;
import static java.time.Instant.parse;
import static java.time.ZoneId.systemDefault;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pawel szymczyk
 */
public class TaximeterTest {

    private final Clock clock = Clock.fixed(parse("2007-12-03T10:15:30.00Z"), systemDefault());
    private final TaximeterFactory taximeterFactory = new TaximeterFactory(clock);

    @Test
    public void shouldCalculatePriceFromGivenTariff() {
        //given
        Taximeter taximeter = taximeterFactory.create(Driver.regular(randomUUID()));

        //when
        Money cost = taximeter.calculate(new RideSummary(10, now(clock), ofMinutes(10)));

        //then
        assertThat(cost).isEqualTo(new Money("75"));
    }

    @Test
    public void shouldAddSpecialFeeForShortRides() {
        //given
        Taximeter taximeter = taximeterFactory.create(Driver.regular(randomUUID()));

        //when
        Money cost = taximeter.calculate(new RideSummary(1, now(clock), ofMinutes(10)));

        //then
        assertThat(cost).isEqualTo(new Money("62"));
    }

    @Test
    public void shouldAddSpecialFeeForBusinessLine() {
        //given
        Taximeter taximeter = taximeterFactory.create(Driver.business(randomUUID()));

        //when
        Money cost = taximeter.calculate(new RideSummary(10, now(clock), ofMinutes(10)));

        //then
        assertThat(cost).isEqualTo(new Money("85"));
    }

    @Test
    public void shouldAddSpecialFeeForNightTravel() {
        //given
        Clock clock = Clock.fixed(parse("2007-12-03T23:55:30.00Z"), systemDefault());
        Taximeter taximeter = new TaximeterFactory(clock).create(Driver.regular(randomUUID()));

        //when
        Money cost = taximeter.calculate(new RideSummary(10, now(clock), ofMinutes(10)));

        //then
        assertThat(cost).isEqualTo(new Money("95"));
    }

}