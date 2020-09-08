package com.tchokoapps.spring.microservices.currencyconversionservice.controllers;

import com.tchokoapps.spring.microservices.currencyconversionservice.beans.CurrencyConversionBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Objects;

@RestController
public class CurrencyConversionController {

    @GetMapping("/current-converter/from/{from}/to/{to}/quantitiy/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        HashMap<String, String> uriVariables = new HashMap<>();

        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class, uriVariables);

        CurrencyConversionBean ccBeanResponse = responseEntity.getBody();

        return new CurrencyConversionBean(Objects.requireNonNull(ccBeanResponse).getId(), ccBeanResponse.getFrom(), ccBeanResponse.getTo(),
                ccBeanResponse.getConversionMultiple(), quantity, quantity.multiply(ccBeanResponse.getConversionMultiple()), ccBeanResponse.getPort());
    }

}
