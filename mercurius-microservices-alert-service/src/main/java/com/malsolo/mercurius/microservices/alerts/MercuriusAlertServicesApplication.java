package com.malsolo.mercurius.microservices.alerts;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MercuriusAlertServicesApplication {

	@Bean
	public CommandLineRunner init(AlertRepository repository) {
		return args -> {
			Arrays.asList(1L, 2L, 3L)
					.stream()
					.map(id -> new Alert(id, id, id, new Date(), id.toString()))
					.forEach(repository::save);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MercuriusAlertServicesApplication.class, args);
	}
}
