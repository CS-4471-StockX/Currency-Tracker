package com.stockx.currencytracker;

import lombok.Data;

import java.util.List;

@Data
public class HistoricalCurrencyConversion {

    private String Currency1;
    private String Currency2;
    private List<Float> Rates;
    private List<String> Dates;

    public HistoricalCurrencyConversion(String c1, String c2, List<Float> rates, List<String> times){
        Currency1 = c1;
        Currency2 = c2;
        Rates = rates;
        Dates = times;
    }

}
