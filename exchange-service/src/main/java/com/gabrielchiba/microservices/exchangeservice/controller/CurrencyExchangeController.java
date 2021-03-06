package com.gabrielchiba.microservices.exchangeservice.controller;

import com.gabrielchiba.microservices.exchangeservice.entity.CurrencyExchange;
//import com.gabrielchiba.microservices.exchangeservice.repository.CurrencyExchangeRepository;
import com.gabrielchiba.microservices.exchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Currency;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {
        logger.info("RetrieveExchangeValue called with {} to {}", from, to);

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if (currencyExchange == null) {
            throw new RuntimeException("Cant find data for " + from + " to " + to);
        }
        return currencyExchange;
//        return new CurrencyExchange(1000L, from, to,
//        BigDecimal.valueOf(50));
    }
}
