package com.pszymczyk.abstraction.shopitem;


import com.pszymczyk.generic.Money;
import org.junit.Test;

public class ShopItemTest {

    @Test
    public void test() {
        ShopItem shopItem = new ShopItem(new Money("10"));

        shopItem.cutPrice(new Money("5"));

        shopItem.getPrice();
    }
}