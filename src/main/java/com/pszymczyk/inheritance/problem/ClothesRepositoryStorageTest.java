package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author pawel szymczyk
 */
public class ClothesRepositoryStorageTest {

    @Test
    public void shouldAddProductToStorage() {
        //given
        ClothesStorage clothesStorage = new ClothesStorage();

        //when
        clothesStorage.add(new Wear());
        clothesStorage.add(new Wear());

        //then
        assertThat(clothesStorage.getClothes().size());
    }

    @Test
    public void addAll() {
        //given
        ClothesStorage clothesStorage = new ClothesStorage();

        //when
        clothesStorage.addAll(new Wear());
        clothesStorage.add(new Wear());

        //then
        assertThat(clothesStorage.getClothes().size());
    }

}