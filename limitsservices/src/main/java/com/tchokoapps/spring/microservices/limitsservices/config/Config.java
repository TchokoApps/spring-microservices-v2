package com.tchokoapps.spring.microservices.limitsservices.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limitsservices")
@Data
public class Config {

    private int min;
    private int max;
}
