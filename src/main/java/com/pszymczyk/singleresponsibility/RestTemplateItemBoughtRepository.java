package com.pszymczyk.singleresponsibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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

    public void save(final ItemBought itemBought) {
        RetryExecutor retry = new RetryExecutor.Builder()
                .retryOnException(HttpClientErrorException.class)
                .retryOnException(HttpServerErrorException.class)
                .withCustomFinalException(new RuntimeException("Cannot send ItemBought event"))
                .withRetryCount(MAX_TRIES)
                .build(callRemoteResource(itemBought));

        retry.run();
    }

    private Runnable callRemoteResource(ItemBought itemBought) {
        return () -> restTemplate.postForEntity(url, itemBought, Void.class);
    }
}
