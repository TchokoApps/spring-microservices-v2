package com.tchokoapps.spring.microservices.currencyexchangeservice.repositories;

import com.tchokoapps.spring.microservices.currencyexchangeservice.entities.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
