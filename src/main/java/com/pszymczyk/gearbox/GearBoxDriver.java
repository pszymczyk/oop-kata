package com.pszymczyk.gearbox;

class GearBoxDriver {

    private final GearCalculators gearCalculators;
    private final EngineMonitoringSystem engineMonitoringSystem;

    private GearCalculator gearCalculator;

    public GearBoxDriver(EngineMonitoringSystem engineMonitoringSystem,
                         GearCalculators gearCalculators) {
        this.engineMonitoringSystem = engineMonitoringSystem;
        this.gearCalculators = gearCalculators;
    }

    public void changeMode(Mode mode){
        this.gearCalculator = gearCalculators.get(mode);
    }

    public void handleGas(double threshold){
        gearCalculator.calculate(engineMonitoringSystem.getCurentRPM(), threshold, 0);
    }

    public void handleBreaks(double force){
        gearCalculator.calculate(engineMonitoringSystem.getCurentRPM(), 0, force);
    }
}
