package com.pszymczyk.polymorphism;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pszymczyk.generic.Money;
import com.pszymczyk.polymorphism.tariff.BusinessDriverTaxiTariffElement;
import com.pszymczyk.polymorphism.tariff.DoorsSlamTaxiTariffElement;
import com.pszymczyk.polymorphism.tariff.KmTaxiTariffElement;
import com.pszymczyk.polymorphism.tariff.NightTaxiTariffElement;
import com.pszymczyk.polymorphism.tariff.ShortTravelTaxiTariffElement;
import com.pszymczyk.polymorphism.tariff.TimeTaxiTariffElement;

public class TaximeterFactory {

    private final List<TaxiTariffElement> tariffElements;
    private final Clock clock;

    public TaximeterFactory(Clock clock) {
        this.clock = clock;
        this.tariffElements = new ArrayList<>();
        this.tariffElements.add(new DoorsSlamTaxiTariffElement(new Money("5")));
        this.tariffElements.add(new KmTaxiTariffElement(new Money("2")));
        this.tariffElements.add(new TimeTaxiTariffElement(new Money("5")));
        this.tariffElements.add(new ShortTravelTaxiTariffElement());
        this.tariffElements.add(new BusinessDriverTaxiTariffElement());
        this.tariffElements.add(new NightTaxiTariffElement());
    }

    public Taximeter create(Driver driver) {
        List<TaxiTariffElement> fees = new ArrayList<>();

        for (TaxiTariffElement tariffElement: tariffElements) {
            if (tariffElement.isApplicable(driver, LocalDateTime.now(clock))) {
                fees.add(tariffElement);
            }
        }

        return new Taximeter(fees);
    }

}
