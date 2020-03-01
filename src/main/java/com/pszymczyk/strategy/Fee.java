package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
interface Fee {

    Money calculate(RideSummary rideSummary);

}
