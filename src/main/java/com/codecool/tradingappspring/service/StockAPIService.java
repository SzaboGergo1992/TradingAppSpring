package com.codecool.tradingappspring.service;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StockAPIService {

    private RemoteURLReader remoteURLReader = new RemoteURLReader();
    private static final String apiPath = "https://financialmodelingprep.com/api/v3/stock/real-time-price/%s";

    public StockAPIService() {
    }

    public StockAPIService(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }

    /** Get stock price from iex and return as a double
     *  @param symbol Stock symbol, for example "aapl"
     **/
    public double getPrice(String symbol) throws IOException {
        String url = String.format(apiPath, symbol);
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);
    }

    /** Buys a share of the given stock at the current price. Returns false if the purchase fails */
    public boolean buy(String symbol) {
        // Stub. No need to implement this.
        return true;
    }

}
