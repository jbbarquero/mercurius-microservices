package com.malsolo.mercurius.microservices.hystrix.client;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class IntegrationClient {

	@Autowired
	private AlertClient alertClient;

	@Autowired
	private EventClient eventClient;

	public Collection<Alert> getAlertsFallback() {
		System.out.println("getAlertsFallback");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getAlertsFallback")
	public Collection<Alert> getAlerts() {
		return this.alertClient.getAlerts();
	}

	public Collection<Event> getEventsFallback() {
		System.out.println("getEventsFallback");
		return Arrays.asList();
	}

	@HystrixCommand(fallbackMethod = "getEventsFallback")
	public Collection<Event> getEvents() {
		return this.eventClient.getEvents();
	}
}
