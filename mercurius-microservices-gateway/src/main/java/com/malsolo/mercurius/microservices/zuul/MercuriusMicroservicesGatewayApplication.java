package com.malsolo.mercurius.microservices.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import reactor.Environment;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableZuulProxy
public class MercuriusMicroservicesGatewayApplication {

	@Bean
	public Environment env() {
		return Environment.initializeIfEmpty();
	}

	public static void main(String[] args) {
        SpringApplication.run(MercuriusMicroservicesGatewayApplication.class, args);
    }
}
