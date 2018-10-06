package com.pszymczyk.singleresponsibility;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @author pawel szymczyk
 */
class ItemBoughtEventHandler {

    private static final int MAX_TRIES = 3;

    private final String url;
    private final RestTemplate restTemplate;

    public ItemBoughtEventHandler(String url) {
        this.url = url;
        this.restTemplate = restTemplate();
    }

    @EventListener
    public void handle(ItemBought itemBought) {
        int count = 0;

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
    }

    private RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(100)
                .setReadTimeout(500)
                .build();
    }
}
