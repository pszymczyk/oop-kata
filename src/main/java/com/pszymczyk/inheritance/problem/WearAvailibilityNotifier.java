package com.pszymczyk.inheritance.problem;

import com.pszymczyk.inheritance.problem.external.Wear;

/**
 * @author pawel szymczyk
 */
interface WearAvailibilityNotifier {
    default void notify(Wear wear) {

    }
}
