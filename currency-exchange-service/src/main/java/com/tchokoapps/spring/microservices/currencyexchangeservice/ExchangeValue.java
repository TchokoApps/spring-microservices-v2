package com.tchokoapps.spring.microservices.currencyexchangeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;

}
