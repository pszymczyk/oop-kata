package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;
import org.joda.time.Duration;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * @author pawel szymczyk
 */
public class CountingClothesStorageTest {

    @Test
    public void shouldIncrementCounterWhenAddNewWear() {
        //given
        Wear wear = new Wear();
        CountingClothesStorage storage = new CountingClothesStorage();

        //when
        storage.add(wear);
        storage.add(wear);

        //then
        assertThat(storage.getClothesCount()).isEqualTo(2);
    }

    @Test
    @Ignore
    public void shouldIncrementCounterWhenAddNewClothes() throws Exception {
        //given
        CountingClothesStorage storage = new CountingClothesStorage();

        //when
        storage.addAll(new Wear(), new Wear(), new Wear());

        //then
        assertThat(storage.getClothesCount()).isEqualTo(3);
    }

    @Test
    public void shouldCountClothesInLessThen50ms() {
        //given
        CountingClothesStorage storage = new CountingClothesStorage();
        storage.addAll(new Wear(), new Wear(), new Wear());

        //when
        long startTime = System.currentTimeMillis();
        storage.getClothesCount();
        long endTime = System.currentTimeMillis();

        //then
        assertThat(Duration.millis(endTime-startTime)).isLessThan(Duration.millis(50));

    }

}