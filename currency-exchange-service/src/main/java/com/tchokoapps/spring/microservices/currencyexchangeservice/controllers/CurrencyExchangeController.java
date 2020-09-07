package com.tchokoapps.spring.microservices.currencyexchangeservice.controllers;

import com.tchokoapps.spring.microservices.currencyexchangeservice.ExchangeValue;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;

    public CurrencyExchangeController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExhangeValue(@PathVariable String from, @PathVariable String to) {

        String serverPort = environment.getProperty("local.server.port");
        ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(650));
        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(serverPort)));
        return exchangeValue;

    }
}
