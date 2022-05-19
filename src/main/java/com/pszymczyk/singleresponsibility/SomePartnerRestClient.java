package com.pszymczyk.singleresponsibility;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

class SomePartnerRestClient {

    private static final int MAX_TRIES = 3;

    private final RestTemplate restTemplate;
    private final String url;

    SomePartnerRestClient(RestTemplate restTemplate, String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    void send(ItemBought itemBought) {
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
        }
    }
}
