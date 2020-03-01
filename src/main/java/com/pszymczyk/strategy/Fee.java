package com.pszymczyk.strategy;

/**
 * @author pawel szymczyk
 */
public interface Fee {

    Money calculate(RideSummary rideSummary);

}
