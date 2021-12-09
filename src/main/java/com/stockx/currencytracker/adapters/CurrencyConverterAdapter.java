package com.stockx.currencytracker.adapters;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
public class CurrencyConverterAdapter {
    private static final String BASE_URL = "https://free.currconv.com/api/v7";

    private final RestTemplate restTemplate;
    private final String apiKey;

    public String currencyConvert(String currencies) {
        String url = UriComponentsBuilder.fromUriString(BASE_URL).path("/convert")
                .queryParam("q", currencies).queryParam("compact", "ultra")
                .queryParam("apiKey", apiKey).build().toUriString();
        return restTemplate.getForObject(url, String.class);
    }
    public String graph(String currencies, String t1, String t2){
        String url = UriComponentsBuilder.fromUriString(BASE_URL).path("/convert")
                .queryParam("q", currencies).queryParam("compact", "ultra")
                .queryParam("date", t1).queryParam("endDate", t2)
                .queryParam("apiKey", apiKey).build().toUriString();
        return restTemplate.getForObject(url, String.class);
    }
}