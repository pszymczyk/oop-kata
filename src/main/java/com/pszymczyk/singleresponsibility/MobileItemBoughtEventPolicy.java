package com.pszymczyk.singleresponsibility;

/**
 * @author pawel szymczyk
 */
class MobileItemBoughtEventPolicy implements ItemBoughtEventHandlerPolicy{

    private final SomePartnerRestClient somePartnerRestClient;

    MobileItemBoughtEventPolicy(SomePartnerRestClient somePartnerRestClient) {
        this.somePartnerRestClient = somePartnerRestClient;
    }

    public void handle(ItemBought itemBought) {
        somePartnerRestClient.send(itemBought);
    }
}
