package com.pszymczyk.strategy;

import java.util.HashMap;
import java.util.Map;

// import com.pszymczyk.strategy.fees.BusinessDriverFee;
// import com.pszymczyk.strategy.fees.DoorsSlamFee;
// import com.pszymczyk.strategy.fees.KmFee;
// import com.pszymczyk.strategy.fees.NightRightFee;
// import com.pszymczyk.strategy.fees.ShortTravelFee;
// import com.pszymczyk.strategy.fees.TimeFee;

class TestBillingConfiguration {

    static Map<Driver, BillingStrategy> getTestConfiguration(
            Driver regular,
            Driver business) {
        Map<Driver, BillingStrategy> config = new HashMap<>();

        //TODO configure driver here - pretty much the same as adding a record into the database

        // config.put(regular, BillingStrategy.feesChain(
        //         new DoorsSlamFee(),
        //         new KmFee(),
        //         new TimeFee(),
        //         new NightRightFee(),
        //         new ShortTravelFee()
        // ));

        // config.put(business, BillingStrategy.feesChain(
        //         new DoorsSlamFee(),
        //         new KmFee(),
        //         new TimeFee(),
        //         new NightRightFee(),
        //         new ShortTravelFee(),
        //         new BusinessDriverFee()
        // ));

        return config;
    }
}
