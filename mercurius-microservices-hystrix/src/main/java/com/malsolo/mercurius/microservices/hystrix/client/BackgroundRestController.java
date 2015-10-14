package com.malsolo.mercurius.microservices.hystrix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackgroundRestController {

	@Autowired
	private IntegrationClient integrationClient;

	@RequestMapping("/passport")
	public Background passport() {
		return new Background(this.integrationClient.getAlerts(),
				this.integrationClient.getEvents());
	}
}
