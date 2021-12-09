package com.stockx.currencytracker.configurations;

import com.stockx.currencytracker.adapters.CurrencyConverterAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Value("${currconv.apiKey}")
    private String currconvApiKey;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CurrencyConverterAdapter currencyConverterAdapter(RestTemplate restTemplate) {
        return new CurrencyConverterAdapter(restTemplate, currconvApiKey);
    }

}
