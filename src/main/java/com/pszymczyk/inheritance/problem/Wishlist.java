package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;

import java.util.Random;

/**
 * @author pawel szymczyk
 */
class Wishlist {

    boolean isOnWishlist(Wear wear) {
        return new Random().nextBoolean();
    }
}
