package com.pszymczyk.inheritance.problem.external;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pawel szymczyk
 *
 * It's external class provided by our trusted provider. Do not modify!
 *
 */
public class ClothesRepository {

    private final List<Wear> repo;

    public ClothesRepository() {
        this.repo = new ArrayList<>();
    }

    public boolean add(Wear wear) {
        return repo.add(wear);
    }

    public List<Wear> findAll() {
        if (System.getProperty("VIP") == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return Collections.unmodifiableList(repo);
    }
}
