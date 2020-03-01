package com.pszymczyk.strategy;

import java.time.Clock;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.Test;

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

    private static final Driver NEW = new Driver(randomUUID());
    private static final Driver REGULAR = Driver.regular(randomUUID());
    private static final Driver BUSINESS = Driver.business(randomUUID());
    private static final Clock clock = Clock.fixed(parse("2007-12-03T10:15:30.00Z"), systemDefault());

    private final TaximeterFactory taximeterFactory = new TaximeterFactory();

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
    public void shouldCalculatePriceForRegularDriver() {
        //given
        Taximeter taximeter = taximeterFactory.create(REGULAR);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("75"));
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
    public void shouldAddSpecialFeeForNightTravelForBusinessLine() {
        //given
        Clock clock = Clock.fixed(parse("2007-12-03T23:55:30.00Z"), systemDefault());
        Taximeter taximeter = taximeterFactory.create(BUSINESS);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("105"));
    }

    @Test
    @Ignore //TODO remove ignore after adding new fee for short rides
    public void shouldAddSpecialFeeForShortRides() {
        //given
        Taximeter taximeter = taximeterFactory.create(REGULAR);

        //when
        taximeter.finish(new RideSummary(1, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("62"));
    }

    @Test
    //TODO remove ignore
    @Ignore
    public void shouldCalculatePriceUsingNewPolicy() {
        //given
        Taximeter taximeter = taximeterFactory.create(NEW);

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("25"));

        //and
        //TODO add posibility to update billing strategy
        // taximeter.updateBillingStrategy(getTestConfiguration(REGULAR, BUSINESS).get(REGULAR));

        //when
        taximeter.finish(new RideSummary(10, now(clock), ofMinutes(10)), clock);

        //then
        assertThat(taximeter.sumUpTheDay(LocalDate.now(clock))).isEqualTo(new Money("25").add(new Money("75")));
    }
}
