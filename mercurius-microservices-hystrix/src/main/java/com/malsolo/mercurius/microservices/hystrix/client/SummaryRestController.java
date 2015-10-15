package com.malsolo.mercurius.microservices.hystrix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaryRestController {

	@Autowired
	private IntegrationClient integrationClient;

	@RequestMapping("/summary")
	public Summary passport() {
		return new Summary(this.integrationClient.getAlerts(),
				this.integrationClient.getEvents());
	}
}
