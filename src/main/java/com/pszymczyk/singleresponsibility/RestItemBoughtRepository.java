package com.pszymczyk.singleresponsibility;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

class RestItemBoughtRepository implements ItemBoughtRepository {

    private static final int MAX_TRIES = 3;

    private final String url;
    private final RestTemplate restTemplate;

    public RestItemBoughtRepository(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    @Override
    public void save(ItemBought itemBought) {
        RetryExecutor retry = new RetryExecutor.Builder()
                .retryOnException(HttpClientErrorException.class)
                .retryOnException(HttpServerErrorException.class)
                .withCustomFinalException(new RuntimeException("Cannot send ItemBought event"))
                .withRetryCount(MAX_TRIES)
                .build(() -> restTemplate.postForEntity(url, itemBought, Void.class));

        retry.run();
    }
}
