package com.pszymczyk.singleresponsibility;

class ItemBoughtEventHandlerFactory {

    private final SomePartnerRestClient somePartnerRestClient;
    private final CampaignsRepository campaignsRepository;

    ItemBoughtEventHandlerFactory(SomePartnerRestClient somePartnerRestClient, CampaignsRepository campaignsRepository) {
        this.somePartnerRestClient = somePartnerRestClient;
        this.campaignsRepository = campaignsRepository;
    }

    ItemBoughtEventHandlerPolicy create(ItemBought.Type type) {
        if (type.equals(ItemBought.Type.MOBILE)) {
            return new MobileItemBoughtEventPolicy(somePartnerRestClient);
        }

        return new DefaultItemBoughtEventHandlerPolicy(campaignsRepository);
    }
}
