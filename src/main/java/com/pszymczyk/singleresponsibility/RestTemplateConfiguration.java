package com.pszymczyk.singleresponsibility;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author pawel szymczyk
 */
@Configuration
class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .setConnectTimeout(100)
                .setReadTimeout(500)
                .build();
    }
}
