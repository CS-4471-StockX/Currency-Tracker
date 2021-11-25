package com.stockx.currencytracker;

import lombok.Data;

@Data
public class CurrencyConversion {

    private String Currency1;
    private String Currency2;
    private Float Rate;

    public CurrencyConversion(String c1, String c2, Float price){
        Currency1 = c1;
        Currency2 = c2;
        Rate = price;
    }
}
