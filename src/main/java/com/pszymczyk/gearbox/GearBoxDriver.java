package com.pszymczyk.gearbox;

class GearBoxDriver {

    private final GearCalculators gearCalculators;
    private final EngineMonitoringSystem engineMonitoringSystem;
    private final GearBox gearBox;

    private GearCalculator gearCalculator;

    public GearBoxDriver(EngineMonitoringSystem engineMonitoringSystem,
            GearCalculators gearCalculators,
            GearBox gearBox) {
        this.engineMonitoringSystem = engineMonitoringSystem;
        this.gearCalculators = gearCalculators;
        this.gearBox = gearBox;
    }

    public void changeMode(Mode mode){
        this.gearCalculator = gearCalculators.get(mode);
    }

    public void handleGas(double threshold){
        gearBox.changeGear(
                gearCalculator.calculate(gearBox.getCurrentGear(), engineMonitoringSystem.getCurrentRPM(), threshold, 0)
        );

    }

    public void handleBreaks(double breakingForce){
        gearBox.changeGear(
                gearCalculator.calculate(gearBox.getCurrentGear(), engineMonitoringSystem.getCurrentRPM(), 0, breakingForce)
        );
    }
}
