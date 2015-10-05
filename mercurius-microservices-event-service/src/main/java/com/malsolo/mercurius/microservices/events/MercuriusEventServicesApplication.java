package com.malsolo.mercurius.microservices.events;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MercuriusEventServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercuriusEventServicesApplication.class, args);
    }
}
