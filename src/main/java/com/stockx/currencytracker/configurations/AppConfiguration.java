package com.stockx.currencytracker.configurations;

import com.stockx.currencytracker.adapters.CurrencyConverterAdapter;
import com.stockx.currencytracker.services.CurrencyTrackerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public CurrencyConverterAdapter currencyConverterAdapter(){
        return new CurrencyConverterAdapter();
    }

}
