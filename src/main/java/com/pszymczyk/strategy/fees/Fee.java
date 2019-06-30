package com.pszymczyk.strategy.fees;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.RideSummary;

/**
 * @author pawel szymczyk
 */
public interface Fee {

    Money calculate(RideSummary rideSummary);

}
