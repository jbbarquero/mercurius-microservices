package com.malsolo.mercurius.microservices.alerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MercuriusAlertServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercuriusAlertServicesApplication.class, args);
    }
}
