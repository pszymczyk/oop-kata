package com.pszymczyk.singleresponsibility;

/**
 * @author pawel szymczyk
 */
class DefaultItemBoughtEventHandlerPolicy implements ItemBoughtEventHandlerPolicy {

    private final CampaignsRepository campaignsRepository;

    DefaultItemBoughtEventHandlerPolicy(CampaignsRepository campaignsRepository) {
        this.campaignsRepository = campaignsRepository;
    }

    public void handle(ItemBought itemBought) {
            CampaignEntity campaignEntity = campaignsRepository.findById(itemBought.getCampaignId());
            campaignEntity.updateSellCount(itemBought.getItemId());
            campaignsRepository.save(campaignEntity);
    }
}
