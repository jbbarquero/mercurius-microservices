package com.malsolo.mercurius.microservices.zuul;

import java.util.Collection;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("event-service")
public interface EventClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/events")
	Collection<Event> getEvents();

}
