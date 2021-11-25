package com.stockx.currencytracker.adapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class CurrencyConverterAdapter {

    @Autowired
    private RestTemplate restTemplate;
    private static final String BASE_URL = "https://free.currconv.com/api/v7";

    public String currencyConvert(String currencies) {
        String url = UriComponentsBuilder.fromUriString(BASE_URL).path("/convert")
                .queryParam("q", currencies).queryParam("compact", "ultra")
                .queryParam("apiKey", "25e94276922318376ed8").build().toUriString();

        return restTemplate.getForObject(url, String.class);
    }

    public String graph(String currencies, String t1, String t2){
        String url = UriComponentsBuilder.fromUriString(BASE_URL).path("/convert")
                .queryParam("q", currencies).queryParam("compact", "ultra")
                .queryParam("date", t1).queryParam("endDate", t2)
                .queryParam("apiKey", "25e94276922318376ed8").build().toUriString();

        return restTemplate.getForObject(url, String.class);
    }

}
