package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;

import java.util.Random;

/**
 * @author pawel szymczyk
 */
interface Wishlist {

    default boolean isOnWishlist(Wear wear) {
        return new Random().nextBoolean();
    }
}
