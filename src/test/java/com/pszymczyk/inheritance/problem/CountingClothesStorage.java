package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;

public class CountingClothesStorage extends ClothesStorage {

    private int counter = 0;

    @Override
    public void add(Wear wear) {
        super.add(wear);
        counter++;
    }

    @Override
    public void addAll(Wear... newWears) {
        super.addAll(newWears);
        counter+=newWears.length;
    }

    public int getClothesCount() {
        return counter;
    }
}
