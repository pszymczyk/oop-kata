package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.ClothesRepository;
import com.pszymczyk.inheritance.problem.external.Wear;

import java.util.Collections;
import java.util.List;

/**
 * @author pawel szymczyk
 */
class ClothesStorage {

    protected final ClothesRepository clothesRepository;
    protected final WearAvailabilityNotifier wearAvailabilityNotifier;
    protected final Wishlist wishlist;

    public ClothesStorage() {
        this.clothesRepository = new ClothesRepository();
        this.wearAvailabilityNotifier = new WearAvailabilityNotifier() { };
        this.wishlist = new Wishlist() { };
    }

    public void add(Wear wear) {
        if (wishlist.isOnWishlist(wear)) {
            wearAvailabilityNotifier.notify(wear);
        }
        clothesRepository.add(wear);
    }

    public void addAll(Wear... newWears) {
        for (Wear w : newWears) {
            add(w);
        }
    }

    public List<Wear> getClothes() {
        return Collections.unmodifiableList(clothesRepository.findAll());
    }
}
