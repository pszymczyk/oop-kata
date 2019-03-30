package com.pszymczyk.strategy;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pszymczyk.generic.Money;
import com.pszymczyk.strategy.tariff.BusinessDriverTaxiTariffElement;
import com.pszymczyk.strategy.tariff.DoorsSlamTaxiTariffElement;
import com.pszymczyk.strategy.tariff.KmTaxiTariffElement;
import com.pszymczyk.strategy.tariff.NightTaxiTariffElement;
import com.pszymczyk.strategy.tariff.ShortTravelTaxiTariffElement;
import com.pszymczyk.strategy.tariff.TimeTaxiTariffElement;

class TaximeterFactory {

    private final List<TaxiTariffElement> tariffElements;
    private final Clock clock;

    TaximeterFactory(Clock clock) {
        this.clock = clock;
        this.tariffElements = new ArrayList<>();
        this.tariffElements.add(new DoorsSlamTaxiTariffElement(new Money("5")));
        this.tariffElements.add(new KmTaxiTariffElement(new Money("2")));
        this.tariffElements.add(new TimeTaxiTariffElement(new Money("5")));
        this.tariffElements.add(new ShortTravelTaxiTariffElement());
        this.tariffElements.add(new BusinessDriverTaxiTariffElement());
        this.tariffElements.add(new NightTaxiTariffElement());
    }

    Taximeter create(Driver driver) {
        List<TaxiTariffElement> fees = new ArrayList<>();

        for (TaxiTariffElement tariffElement: tariffElements) {
            if (tariffElement.isApplicable(driver, LocalDate.now(clock))) {
                fees.add(tariffElement);
            }
        }

        return new Taximeter(fees);
    }

}
