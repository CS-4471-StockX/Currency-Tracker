package com.stockx.currencytracker.controllers;

import com.stockx.currencytracker.CurrencyConversion;
import com.stockx.currencytracker.HistoricalCurrencyConversion;
import com.stockx.currencytracker.services.CurrencyTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyTrackerController {

    @Autowired
    private CurrencyTrackerService currencyTrackerService;

    @CrossOrigin(origins = "https://www.stockx.software")
    @GetMapping("/currencies")
    public CurrencyConversion convertCurrencies(@RequestParam("c1")  String c1, @RequestParam("c2") String c2){
        return currencyTrackerService.convertCurrencies(c1,c2);
    }

    @CrossOrigin(origins = "https://www.stockx.software")
    @GetMapping("/graph")
    public HistoricalCurrencyConversion graph(@RequestParam("c1")  String c1, @RequestParam("c2") String c2){
        return currencyTrackerService.convertHistorical(c1,c2);
    }

}
