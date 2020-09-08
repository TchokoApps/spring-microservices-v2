package com.tchokoapps.spring.microservices.currencyexchangeservice.controllers;

import com.tchokoapps.spring.microservices.currencyexchangeservice.entities.ExchangeValue;
import com.tchokoapps.spring.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    private final Environment environment;

    private CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeService currencyExchangeService) {
        this.environment = environment;
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExhangeValue(@PathVariable String from, @PathVariable String to) {

        String serverPort = environment.getProperty("local.server.port");
        ExchangeValue exchangeValue = currencyExchangeService.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(Objects.requireNonNull(serverPort)));
        return exchangeValue;

    }
}
