package com.malsolo.mercurius.microservices.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MercuriusEurekaServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercuriusEurekaServicesApplication.class, args);
    }
}
