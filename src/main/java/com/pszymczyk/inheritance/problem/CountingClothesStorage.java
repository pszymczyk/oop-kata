package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;

import java.util.List;

/**
 * @author pawel szymczyk
 */
class CountingClothesStorage extends ClothesStorage {

    private int counter = 0;

    @Override
    public void add(Wear wear) {
        super.add(wear);
        ++counter;
    }

    @Override
    public void addAll(Wear... newWears) {
        super.addAll(newWears);
        counter+=newWears.length;
    }

    public List<Wear> getClothes() {
        return super.getClothes();
    }

    public int getClothesCount() {
        return counter;
    }
}
