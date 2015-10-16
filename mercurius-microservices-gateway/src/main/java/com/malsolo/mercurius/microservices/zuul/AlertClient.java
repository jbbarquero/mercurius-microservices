package com.malsolo.mercurius.microservices.zuul;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("alert-service")
public interface AlertClient {

	@RequestMapping(method = RequestMethod.GET, value = "/alerts")
	Collection<Alert> getAlerts();
}
