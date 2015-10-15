package com.malsolo.mercurius.microservices.events;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MercuriusEventServicesApplication {

	@Bean
	public CommandLineRunner init(EventRepository repository) {
		return args -> {
			Arrays.asList(90L, 91L, 92L, 93L, 94L, 95L)
					.stream()
					.map(id -> new Event(id, id, id.toString(), id.toString(), new Date(), null, null, null))
					.forEach(repository::save);
		};
	}
    public static void main(String[] args) {
        SpringApplication.run(MercuriusEventServicesApplication.class, args);
    }
}
