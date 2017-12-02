package com.pszymczyk.gearbox;

import java.util.Map;

public class GearCalculators {

    private Map<Mode, GearCalculator> calculators;

    public GearCalculators(Map<Mode, GearCalculator> calculators) {
        this.calculators = calculators;
    }

    public GearCalculator get(Mode mode) {
        return calculators.get(mode);
    }
}
