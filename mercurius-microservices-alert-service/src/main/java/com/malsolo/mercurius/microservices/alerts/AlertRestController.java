package com.malsolo.mercurius.microservices.alerts;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerts")
public class AlertRestController {
	
	private final AlertRepository alertRepository;

	@Autowired
	public AlertRestController(AlertRepository alertRepository) {
		super();
		this.alertRepository = alertRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Alert> getAllAlerts() {
		return this.alertRepository.findAll();
	}

	@RequestMapping(value = "/{alertId}", method = RequestMethod.GET)
	public Alert getEvent(@PathVariable Long alertId) {
		return this.alertRepository.findOne(alertId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Alert createAlert(@RequestBody Alert alert) {
		return this.alertRepository.save(new Alert(null, alert.getIdType(),
				alert.getIdEvent(), new Date(), alert.getMessage()));
	}

}
