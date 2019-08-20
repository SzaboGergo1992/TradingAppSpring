package com.codecool.tradingappspring.service;

import com.codecool.tradingappspring.logger.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Trader {

    @Autowired
    private Logger logger;

    @Autowired
    private StockAPIService stockAPIService;

    public boolean buy(String symbol, double bid) throws IOException {
        double price = stockAPIService.getPrice(symbol);

        boolean result;
        if (price <= bid) {
            result = true;
            stockAPIService.buy(symbol);
            logger.log("Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")");
        }
        else {
            logger.log("Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.");
            result = false;
        }
        return result;
    }

}
