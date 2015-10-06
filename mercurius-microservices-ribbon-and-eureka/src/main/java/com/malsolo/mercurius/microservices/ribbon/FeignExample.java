package com.malsolo.mercurius.microservices.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class FeignExample implements CommandLineRunner {

	@Autowired
	private EventClient eventClient;

	@Autowired
	private AlertClient alertClient;

	@Override
	public void run(String... args) throws Exception {
		this.eventClient.getEvents().forEach(System.err::println);
		this.alertClient.getAlerts().forEach(System.err::println);
	}

}
