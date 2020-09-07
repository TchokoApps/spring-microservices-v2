package com.tchokoapps.spring.microservices.limitsservices.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigController {

    private Config config;

    public LimitConfigController(Config config) {
        this.config = config;
    }

    @GetMapping("/limits")
    public LimitConfig retrieveLimitsFromConfigs() {
        return new LimitConfig(config.getMin(), config.getMax());
    }
}
