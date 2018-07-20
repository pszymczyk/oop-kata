package com.pszymczyk.singleresponsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author pawel szymczyk
 */
class RestTemplateItemBoughtRepository implements ItemBoughtRepository{

    private static final int MAX_TRIES = 3;

    private final String url;
    private final RestTemplate restTemplate;

    @Autowired
    public RestTemplateItemBoughtRepository(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public void save(final ItemBought itemBought) {
       //todo retry
    }
}
