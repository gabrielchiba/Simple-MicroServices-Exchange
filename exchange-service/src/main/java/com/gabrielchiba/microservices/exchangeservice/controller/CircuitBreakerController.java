package com.gabrielchiba.microservices.exchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private Logger logger =
            LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodeResponse")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodeResponse")
    @Bulkhead(name="sample-api")
    @RateLimiter(name = "default")
    public String sampleApi() {
        logger.info("Sample api call received");
        return "Sample API";
    }
    public String hardcodeResponse(Exception ex) {
        return "fallback-response";
    }
}
