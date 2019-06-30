package com.pszymczyk.strategy;

import java.time.Clock;
import java.time.LocalDate;

import org.junit.Test;

import com.pszymczyk.generic.Money;

import static com.pszymczyk.strategy.TestBillingConfiguration.getTestConfiguration;
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

    private static final Driver NEW = Driver.regular(randomUUID());
    private static final Driver REGULAR = Driver.regular(randomUUID());
    private static final Driver BUSINESS = Driver.business(randomUUID());
    private static final Clock clock = Clock.fixed(parse("2007-12-03T10:15:30.00Z"), systemDefault());

    private final TaximeterFactory taximeterFactory = new TaximeterFactory(getTestConfiguration(REGULAR, BUSINESS));

    @Test
    public void shouldCalculatePriceFromGivenTariff() {
        //given
        Taximeter taximeter = taximeterFactory.create(REGULAR);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("75"));
    }

    @Test
    public void shouldAddSpecialFeeForShortRides() {
        //given
        Taximeter taximeter = taximeterFactory.create(REGULAR);

        //when
        taximeter.finish(new RideSummary(1, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("62"));
    }

    @Test
    public void shouldAddSpecialFeeForBusinessLine() {
        //given
        Taximeter taximeter = taximeterFactory.create(BUSINESS);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("85"));
    }

    @Test
    public void shouldAddSpecialFeeForNightTravel() {
        //given
        Clock clock = Clock.fixed(parse("2007-12-03T23:55:30.00Z"), systemDefault());
        Taximeter taximeter = taximeterFactory.create(REGULAR);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("95"));
    }

    @Test
    public void shouldCalculatePriceForNewDriver() {
        //given
        Taximeter taximeter = taximeterFactory.create(NEW);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("25"));
    }

    @Test
    public void shouldCalculatePriceUsingNewPolicy() {
        //given
        Taximeter taximeter = taximeterFactory.create(NEW);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("25"));

        //and
        taximeter.updateBillingStrategy(getTestConfiguration(REGULAR, BUSINESS).get(REGULAR));

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("25").add(new Money("75")));
    }
}