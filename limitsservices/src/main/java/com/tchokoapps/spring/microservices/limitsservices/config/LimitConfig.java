package com.tchokoapps.spring.microservices.limitsservices.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitConfig {
    int min;
    int max;
}