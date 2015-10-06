package com.malsolo.mercurius.microservices.ribbon;

import static org.springframework.http.HttpMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Order(2)
@Component
public class RestTemplateExample implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {

		ParameterizedTypeReference<List<Event>> responseType = new ParameterizedTypeReference<List<Event>>() {
		};

		ResponseEntity<List<Event>> exchange = this.restTemplate.exchange(
				"http://event-service/{eventId}", GET, null, responseType,
				Long.valueOf(1));
		
		exchange.getBody().forEach(System.err::println);

	}

}
