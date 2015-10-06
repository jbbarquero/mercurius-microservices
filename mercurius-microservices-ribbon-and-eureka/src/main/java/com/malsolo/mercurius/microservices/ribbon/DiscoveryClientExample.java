package com.malsolo.mercurius.microservices.ribbon;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DiscoveryClientExample implements CommandLineRunner {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public void run(String... args) throws Exception {
		discoveryClient.getInstances("alert-service").forEach(
				s -> System.err.println(reflectionToString(s)));

		discoveryClient.getInstances("event-service").forEach(
				serviceInstance -> System.err
						.println(reflectionToString(serviceInstance)));
	}

}
