package com.malsolo.mercurius.microservices.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class MercuriusMicroservicesHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercuriusMicroservicesHystrixApplication.class, args);
    }
}
