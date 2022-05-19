package com.pszymczyk.singleresponsibility;

import org.springframework.context.event.EventListener;

/**
 * @author pawel szymczyk
 */
class ItemBoughtEventHandler {

    private final SomePartnerRestClient somePartnerRestClient;
    private final CampaignsRepository campaignsRepository;

    public ItemBoughtEventHandler(SomePartnerRestClient somePartnerRestClient, CampaignsRepository campaignsRepository) {
        this.somePartnerRestClient = somePartnerRestClient;
        this.campaignsRepository = campaignsRepository;
    }

    @EventListener
    public void handle(ItemBought itemBought) {
        if (itemBought.getType() == ItemBought.Type.MOBILE) {
            somePartnerRestClient.send(itemBought);
        } else {
            CampaignEntity campaignEntity = campaignsRepository.findById(itemBought.getCampaignId());
            campaignEntity.updateSellCount(itemBought.getItemId());
            campaignsRepository.save(campaignEntity);
        }
    }
}
