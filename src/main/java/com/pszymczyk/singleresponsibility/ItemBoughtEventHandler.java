package com.pszymczyk.singleresponsibility;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * @author pawel szymczyk
 */
class ItemBoughtEventHandler {

    private static final int MAX_TRIES = 3;

    private final String url;
    private final RestTemplate restTemplate;
    private final CampaignsRepository campaignsRepository;

    public ItemBoughtEventHandler(String url, CampaignsRepository campaignsRepository) {
        this.url = url;
        this.restTemplate = restTemplate();
        this.campaignsRepository = campaignsRepository;
    }

    @EventListener
    public void handle(ItemBought itemBought) {
        int count = 0;

        if (itemBought.getType() == ItemBought.Type.MOBILE) {
            while (true) {
                try {
                    restTemplate.postForEntity(url, itemBought, Void.class);
                    return;
                } catch (HttpClientErrorException | HttpServerErrorException ex) {
                    if (++count == MAX_TRIES) {
                        throw new RuntimeException("Cannot send ItemBought event");
                    }
                }
            }
        } else {
            CampaignEntity campaignEntity = campaignsRepository.findById(itemBought.getCampaignId());
            campaignEntity.updateSellCount(itemBought.getItemId());
            campaignsRepository.save(campaignEntity);
        }
    }

    private RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(Duration.ofMillis(100))
                .setReadTimeout(Duration.ofMillis(100))
                .build();
    }
}
