package com.tchokoapps.spring.microservices.currencyexchangeservice.services;

import com.tchokoapps.spring.microservices.currencyexchangeservice.entities.ExchangeValue;
import com.tchokoapps.spring.microservices.currencyexchangeservice.repositories.ExchangeValueRepository;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeService {

    private ExchangeValueRepository exchangeValueRepository;

    public CurrencyExchangeService(ExchangeValueRepository exchangeValueRepository) {
        this.exchangeValueRepository = exchangeValueRepository;
    }

    public ExchangeValue findByFromAndTo(String from, String to) {
        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
