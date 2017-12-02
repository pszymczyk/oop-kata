package com.pszymczyk.abstraction.shopitem;

import com.pszymczyk.generic.Money;

public class ShopItem {

    private Money price;

    public ShopItem(Money price) {
        this.price = price;
    }

    public void cutPrice(Money money) {
        price = price.substract(money);
    }

    public Money getPrice() {
        return price;
    }
}
