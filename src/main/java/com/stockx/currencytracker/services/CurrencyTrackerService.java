package com.stockx.currencytracker.services;

import com.stockx.currencytracker.CurrencyConversion;
import com.stockx.currencytracker.HistoricalCurrencyConversion;
import com.stockx.currencytracker.adapters.CurrencyConverterAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyTrackerService {

    @Autowired
    private CurrencyConverterAdapter currencyConverterAdapter;

    public CurrencyConversion convertCurrencies(String currency1, String currency2){
        String cur = currencyConverterAdapter.currencyConvert(currency1 + "_" + currency2);
        cur = cur.replace("{", "");
        cur = cur.replaceAll("}", "");
        cur = cur.replaceAll("\"", "");
        String[] parts = cur.split(":");
        String[] curs = parts[0].split("_");

        return new CurrencyConversion(curs[0], curs[1], Float.valueOf(parts[1]));

    }

    public HistoricalCurrencyConversion convertHistorical(String currency1, String currency2){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long time = System.currentTimeMillis();
        String endDate = dateFormat.format(time);
        String startDate = dateFormat.format(time-604800000);

        String cur = currencyConverterAdapter.graph(currency1 + "_" + currency2, startDate, endDate);
        cur = cur.replace("{", "");
        cur = cur.replaceAll("}", "");
        cur = cur.replaceAll("\"", "");
        String[] parts = cur.split(":");
        String[] values = cur.split(",");
        String[] curs = parts[0].split("_");

        List<Float> rates = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        rates.add(Float.valueOf(values[0].split(":")[2]));
        dates.add(values[0].split(":")[1]);
        for(int i = 1; i < values.length-1; i++){
            String[] rateAndDate = values[i].split(":");
            rates.add(Float.valueOf(rateAndDate[1]));
            dates.add(rateAndDate[0]);
        }

        return new HistoricalCurrencyConversion(curs[0], curs[1], rates, dates);
    }

}
