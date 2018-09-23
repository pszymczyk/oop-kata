package com.pszymczyk.vendingmachine;

import java.util.List;

public interface VendingMachine {

    String getDisplay();

    void insertCoin(Coin coin);

    List<Coin> getCoinReturnTray();

    List<Product> getProductDispensionTray();
}
