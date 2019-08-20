package com.codecool.tradingappspring.controller;

import com.codecool.tradingappspring.service.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/buy")
public class BidController {

    @Autowired
    private Trader trader;

    @GetMapping("/{stock}/{bid}")
    public boolean tryToBuy(@PathVariable("stock") String stock, @PathVariable("bid") double bid) throws IOException {
        return trader.buy(stock, bid);
    }

}
